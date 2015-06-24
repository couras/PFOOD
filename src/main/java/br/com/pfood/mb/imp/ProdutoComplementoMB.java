/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;

import br.com.pfood.bo.ProdutoComplementoBO;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import br.com.pfood.model.Usuario;
import br.com.pfood.util.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.criterion.Order;

/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoComplementoMB")
@ViewScoped
public class ProdutoComplementoMB extends GenericMBImp<ProdutoComplemento> {

    @Inject
    ProdutoComplementoBO produtoComplementoBO;
    private List<Complemento> listaComplemento = new ArrayList<Complemento>();
    private Produto produto;
    private int action = 0;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
        switch (action) {
            case 1:
                novo();
                ObjectUtil.preparaObjetoParaBusca(obj);
                obj.setProduto(produto);
                obj.setTipo(action);
                super.setLista(produtoComplementoBO.getPorAtributosIguais(obj, Order.asc("sequencia")));
                novo();
                break;
        }
    }

    public ProdutoComplementoBO getProdutoComplementoBO() {
        return produtoComplementoBO;
    }

    public void setProdutoComplementoBO(ProdutoComplementoBO produtoComplementoBO) {
        this.produtoComplementoBO = produtoComplementoBO;
    }

    private Usuario user = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void observerComplementos(@Observes List<Complemento> complementos) {
        this.listaComplemento = complementos;
    }

    public void observerProduto(@Observes Produto produto) {
        this.produto = produto;
        setAction(1);
    }

    @PostConstruct
    public void init() {
        super.init(produtoComplementoBO);
        user = new Usuario();
    }

    @Override
    public void save() {

        obj.setTipo(action);
        obj.setProduto(produto);
        super.save();
    }

    public List<Complemento> autoCompleteComplemento(String query) {
        return listaComplemento
                .stream()
                .filter(c
                        -> c.getDescricao().toLowerCase()
                        .contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

}
