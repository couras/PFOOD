/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.filter;

import br.com.pfood.util.HttpUtil;
import java.io.IOException;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Abre uma sessao por requisição do criente para evitar lazyLoading durante
 * o uso na view. commita tudo no final mas não fecha a sessao pois é
 * responsabilidade do próprio objeto que a produz, SessionProdutor
 * @author r.palazzio
 */
@WebFilter(urlPatterns = "/protected/*")
public class OpenSessionInViewFilter implements Filter {

    @Inject
    private Instance<Session> session;
    @Inject
    private transient Logger logger;
    @Inject 
    private HttpUtil httpUtil;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            httpUtil.setHttpServletRequest((HttpServletRequest)request);
            session.get().beginTransaction();
            logger.debug("antes chain.doFilter()");
            chain.doFilter(request, response);
            logger.debug("depois chain.doFilter()");
            if (session.get().getTransaction().isActive()) {
                session.get().getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
        } finally {
            if (session.get().getTransaction() != null && session.get().getTransaction().isActive()) {
                session.get().getTransaction().rollback();
            }
        }
    }

    @Override
    public void destroy() {
        
    }
}
