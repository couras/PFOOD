/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.util;

import br.com.pfood.qualifier.Bundle;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


/**
 *Toda messangem de tela adiciona por um Named bean deve ser adicionada por essa classe
 * @author r.palazzio
 */
public class MessageUtil implements Serializable{
   
        @Inject @Bundle(tipo = "label")
        private transient ResourceBundle bundleLabel;
        
	public  void  addMenssageSuccess( String body){
		FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_INFO, bundleLabel.getString("lblSucesso"),
				body));
	}
	
	public  void  addMenssageWarn(String body){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, bundleLabel.getString("lblAtencao") ,
				body));
	}
	
	public  void  addMenssageError( String body){
		          FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_ERROR, bundleLabel.getString("lblErro"),
				body));
	}
	
	public void  addMenssageFatal(String body){
		FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_FATAL, bundleLabel.getString("lblFatal") ,
				body));
	}
	
}
