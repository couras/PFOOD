/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ComplementoBO;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author r.palazzio
 */
@Named(value = "complementoMB")
@ViewScoped
public class ComplementoMB extends GenericMBImp<Complemento>{
    
    @Inject ComplementoBO complementcBO;
    private Usuario user  = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(complementcBO);
        user = new Usuario();
        super.getAll();
    }



    
}
