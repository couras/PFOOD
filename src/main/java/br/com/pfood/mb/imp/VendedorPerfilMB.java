/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.VendedorBO;
import br.com.pfood.model.VendedorPerfil;
import br.com.pfood.model.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;


/**
 *
 * @author r.palazzio
 */
@Named(value = "vendedorPerfilMB")
@ViewScoped
public class VendedorPerfilMB extends GenericMBImp<VendedorPerfil>{
    
    @Inject VendedorBO vendedorBO;
    @Inject UsuarioLogadoMB usuarioLogado;
    private Usuario user  = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(vendedorBO);
        user = new Usuario();
        super.getAll();
    }

    @Override
    public void save(){
        obj.setVendedor(usuarioLogado.getUsuario().getVendedor());
        super.save();
    }


    
}
