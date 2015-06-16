/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.util;

import java.io.Serializable;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author r.palazzio
 */
@SessionScoped
public class HttpUtil implements Serializable {

    private HttpServletRequest request;
    @Inject
    private transient Logger logger;

    @PostConstruct
    public void HttpUtil() {
        logger.debug("Constuido httpUtil");
    }

    public HttpServletRequest getHttpRequest() {
        return request;
    }

    public void setHttpServletRequest(HttpServletRequest request) {
        logger.debug("setando request " + this.getClass().getSimpleName());
        this.request = request;
    }

    public String getPrimeiroNomeURL() {
        String[] vector = (String[]) getHttpRequest().getServerName().split(Pattern.quote("."));
        if (vector[0].equals("localhost") || vector[0].equals("192")) {
            return "desenvolvimento";
        } else {
            return vector[0];
        }
    }
}
