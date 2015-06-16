/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;



import br.com.pfood.model.Usuario;
import br.com.pfood.qualifier.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author r.palazzio
 */
@Named(value = "usuarioLogadoMB")
@SessionScoped
public class UsuarioLogadoMB implements Serializable {

    private Usuario usuario;

    private String urlServico;

    
    @Inject
    @Bundle(tipo = "nomeServico")
    private transient ResourceBundle bundleNomeServico;
    

    public ResourceBundle getBundleNomeServico() {
        return bundleNomeServico;
    }

    public void setBundleNomeServico(ResourceBundle bundleNomeServico) {
        this.bundleNomeServico = bundleNomeServico;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUrlServico() {
        return urlServico;
    }

    public void setUrlServico(String urlServico) {
        this.urlServico = urlServico;
    }

    public String getServico(String nomeServicoBundle) {
        return this.getUrlServico() + bundleNomeServico.getString(nomeServicoBundle);
    }

  

 

}
