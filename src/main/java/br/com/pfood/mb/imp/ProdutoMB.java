/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ProdutoBO;
import br.com.pfood.enumerated.SituacaoEnum;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Produto;
import br.com.pfood.model.Usuario;
import br.com.pfood.util.Encrypt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;


/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB extends GenericMBImp<Produto>{
    
    @Inject ProdutoBO produtoBO;
    private Usuario user  = null;

    private List<Complemento> listaTargetComplementoPadrao;
    private List<Complemento> listaTargetComplementoAdicional;
    

    private DualListModel<Complemento> dualListComplementoPadrao;
    private DualListModel<Complemento> dualListComplementoAdiconal;

    public DualListModel<Complemento> getDualListComplementoPadrao() {
        return dualListComplementoPadrao;
    }

    public void setDualListComplementoPadrao(DualListModel<Complemento> dualListComplementoPadrao) {
        this.dualListComplementoPadrao = dualListComplementoPadrao;
    }

    public DualListModel<Complemento> getDualListComplementoAdiconal() {
        return dualListComplementoAdiconal;
    }

    public void setDualListComplementoAdiconal(DualListModel<Complemento> dualListComplementoAdiconal) {
        this.dualListComplementoAdiconal = dualListComplementoAdiconal;
    }

    public List<Complemento> getListaTargetComplementoPadrao() {
        return listaTargetComplementoPadrao;
    }

    public void setListaTargetComplementoPadrao(List<Complemento> listaTargetComplementoPadrao) {
        this.listaTargetComplementoPadrao = listaTargetComplementoPadrao;
    }

    public List<Complemento> getListaTargetComplementoAdicional() {
        return listaTargetComplementoAdicional;
    }

    public void setListaTargetComplementoAdicional(List<Complemento> listaTargetComplementoAdicional) {
        this.listaTargetComplementoAdicional = listaTargetComplementoAdicional;
    }



    public ProdutoBO getProdutoBO() {
        return produtoBO;
    }

    public void setProdutoBO(ProdutoBO produtoBO) {
        this.produtoBO = produtoBO;
    }

 
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
        listaTargetComplementoPadrao = new ArrayList<Complemento>();
        listaTargetComplementoAdicional = new ArrayList<Complemento>();
        this.montaDualListComplemento(new ArrayList<Complemento>());
    }

  private void montaDualListComplemento(List<Complemento> listaSourceComplemento){
      this.dualListComplementoAdiconal = new DualListModel<Complemento>(listaSourceComplemento , listaTargetComplementoAdicional);
      this.dualListComplementoPadrao = new DualListModel<Complemento>(listaSourceComplemento , listaTargetComplementoPadrao);
  }
  public void listnerComplemento(@Observes List<Complemento> complemento){
      this.montaDualListComplemento(complemento);
  }

    
}
