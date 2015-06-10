/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ProdutoBO;
import br.com.pfood.enumerated.SituacaoEnum;
import br.com.pfood.model.Produto;
import br.com.pfood.model.Usuario;
import br.com.pfood.util.Encrypt;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;


/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB extends GenericMBImp<Produto>{
    
    @Inject ProdutoBO produtoBO;
    private Usuario user  = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(produtoBO);
        user = new Usuario();
    }



    
}
