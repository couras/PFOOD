/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.produces;

import br.com.pfood.dao.imp.HibernateUtil;
import br.com.pfood.util.UsuarioUtil;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author r.palazzio
 * 
 * Classe responsável pelo controle de sessao
 * A cada requisição  abre uma sessao e fecha no final.
 * É composição do filtro OpenSessionInVeiw
 * 
 */

public class SessionProdutor {
    
    private Session session;
    @Inject
    private transient  Logger logger;
    @Inject
    private transient UsuarioUtil usuarioUtil;
    
    @Produces @RequestScoped 
    public Session produtorSession(){
        this.session  = HibernateUtil.getSessionFactory(
                usuarioUtil.getDataBase()).openSession();
        logger.debug("Sessao hibernate aberta");
        return session;
    }
    
    public void fechaSession(@Disposes Session session){
        session.clear();
        session.close();
        session =null;
        logger.debug("Sessao hibernate fechada");
    }
    
}
