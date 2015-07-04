/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ComplementoBO;
import br.com.pfood.bo.ProdutoBO;
import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import br.com.pfood.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;


/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB extends GenericMBImp<Produto>{
    
    @Inject ProdutoBO produtoBO;
    @Inject UsuarioLogadoMB usuarioLogado;
    @Inject Event<Produto> evtPtoduto;
    private Usuario user  = null;
            



    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ProdutoBO getProdutoBO() {
        return produtoBO;
    }

    public void setProdutoBO(ProdutoBO produtoBO) {
        this.produtoBO = produtoBO;
    }

    public UsuarioLogadoMB getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioLogadoMB usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

 


    
    
    @PostConstruct
    public void   init(){
        super.init(produtoBO);
        user = new Usuario();
        super.getAll();
        super.novoAoGravar= false;

    }

    @Override
    public void save(){
        obj.setVendedor(usuarioLogado.getUsuario().getVendedor());
        super.save();
        evtPtoduto.fire(obj);
              
    }

  public void setProduto(Produto  p){
      super.obj  = p;
      evtPtoduto.fire(obj);
  }
    
}
