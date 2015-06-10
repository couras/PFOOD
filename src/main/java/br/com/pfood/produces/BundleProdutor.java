/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.produces;

import br.com.pfood.mb.imp.LocaleControlerMB;
import br.com.pfood.qualifier.Bundle;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author r.palazzio
 */
public class BundleProdutor implements Serializable{
    @Inject 
    private LocaleControlerMB locale;
    private ResourceBundle bundleLabel =null;
    private ResourceBundle bundleMessage  = null;
    private ResourceBundle bundleUrlServico  = null;
    private ResourceBundle bundleNomeServico  = null;
    
    
    
    @Produces @Bundle(tipo = "label") 
    public ResourceBundle getBundleLabel(){
        if(bundleLabel==null){
            bundleLabel = ResourceBundle.getBundle("label", locale.getCurrentLocale());
        }
        return bundleLabel;
    }
    
    @Produces @Bundle(tipo = "mensagens")
    public ResourceBundle getBundleMesages(){ 
        if(bundleMessage == null ){
            bundleMessage =  ResourceBundle.getBundle("mensagens", locale.getCurrentLocale());
        }
        return bundleMessage;
    }
    
    @Produces @Bundle(tipo = "urlServico") 
    public ResourceBundle getBundleUrlBase(){
        if(bundleUrlServico==null){
            bundleUrlServico = ResourceBundle.getBundle("urlServico");
        }
        return bundleUrlServico;
    }
    
    @Produces @Bundle(tipo = "nomeServico") 
    public ResourceBundle getBundleNomeServico(){
        if(bundleNomeServico==null){
            bundleNomeServico = ResourceBundle.getBundle("nomeServico");
        }
        return bundleNomeServico;
    }
    
    public void zeraLanguage(){
        this.bundleLabel=null;
        this.bundleMessage=null;
    }
}
