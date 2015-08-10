/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;

import br.com.pfood.bo.ProdutoComplementoBO;
import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import br.com.pfood.model.TipoAgrupamentoComplemento;
import br.com.pfood.model.Usuario;
import br.com.pfood.util.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.criterion.Order;
import org.primefaces.context.RequestContext;

/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoComplementoMB")
@ViewScoped
public class ProdutoComplementoMB extends GenericMBImp<ProdutoComplemento> {

    @Inject
    ProdutoComplementoBO produtoComplementoBO;
    @Inject
    UsuarioLogadoMB usuarioLogado;
    private List<Complemento> listaComplemento = new ArrayList<Complemento>();
    private Produto produto;
    private int action = 0; 
    private List<TipoAgrupamentoComplemento> listaTipoAgrupamentoComplemento;
    // essa lista recebe apenas o 3 complemento principais, adicional, padrao e opcional
    private List<TipoAgrupamentoComplemento> listaTipoAgrupamentoComplementoPadroes;
    
    private TipoAgrupamentoComplemento tipoAgrupamentoComplemento;
    private TipoAgrupamentoComplemento tipoAgrupamentoComplementoSelecionado;

    public TipoAgrupamentoComplemento getTipoAgrupamentoComplementoSelecionado() {
        return tipoAgrupamentoComplementoSelecionado;
    }

    public List<TipoAgrupamentoComplemento> getListaTipoAgrupamentoComplementoPadroes() {
        return listaTipoAgrupamentoComplementoPadroes;
    }

    public void setListaTipoAgrupamentoComplementoPadroes(List<TipoAgrupamentoComplemento> listaTipoAgrupamentoComplementoPadroes) {
        this.listaTipoAgrupamentoComplementoPadroes = listaTipoAgrupamentoComplementoPadroes;
    }

    public void setTipoAgrupamentoComplementoSelecionado(TipoAgrupamentoComplemento tipoAgrupamentoComplementoSelecionado) {
        this.tipoAgrupamentoComplementoSelecionado = tipoAgrupamentoComplementoSelecionado;
    }

    public List<TipoAgrupamentoComplemento> getListaTipoAgrupamentoComplemento() {
        return listaTipoAgrupamentoComplemento;
    }

    public void setListaTipoAgrupamentoComplemento(List<TipoAgrupamentoComplemento> listaTipoAgrupamentoComplemento) {
        this.listaTipoAgrupamentoComplemento = listaTipoAgrupamentoComplemento;
    }

    public TipoAgrupamentoComplemento getTipoAgrupamentoComplemento() {
        return tipoAgrupamentoComplemento;
    }

    public void setTipoAgrupamentoComplemento(TipoAgrupamentoComplemento tipoAgrupamentoComplemento) {
        this.tipoAgrupamentoComplemento = tipoAgrupamentoComplemento;
    }
    
    public List<Complemento> getListaComplemento() {
        return listaComplemento;
    }

    public void setListaComplemento(List<Complemento> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
        ObjectUtil.preparaObjetoParaBusca(obj);
        obj.setProduto(produto);
        switch (action) {
            case 1:
                obj.setTipo(ProdutoComplementoTipoEnum.PADRAO.getTipo());
                break;
            case 2:
                obj.setTipo(ProdutoComplementoTipoEnum.ADICIONAL.getTipo());
                break;
            case 3:
                obj.setTipo(ProdutoComplementoTipoEnum.OPCIONAL.getTipo());
                break;
        }
        if (produto != null && produto.getIdProduto() > 0) {
            super.setLista(produtoComplementoBO.getPorAtributosIguais(obj, Order.asc("sequencia")));
        }

        novo();
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
        try {
            listaTipoAgrupamentoComplementoPadroes = produtoComplementoBO.getAllLimit(TipoAgrupamentoComplemento.class, null, 0, 3);
            listaTipoAgrupamentoComplemento = produtoComplementoBO.getTipoComplementoByVendor(usuarioLogado.getUsuario().getVendedor()) ;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ProdutoComplementoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaTipoAgrupamentoComplemento
               .sort((t1 , t2) 
                       -> t1.getIdTipoAgrupamentoComplemento().compareTo(t2.getIdTipoAgrupamentoComplemento()));
        tipoAgrupamentoComplemento = new TipoAgrupamentoComplemento();
    }

    @Override
    public void save() {

        obj.setTipo(action);
        obj.setProduto(produto);
        if(action==1)
            obj.setTipoAgrupamentoComplemento(listaTipoAgrupamentoComplementoPadroes.get( 0 ));
        if(action==2)
            obj.setTipoAgrupamentoComplemento(listaTipoAgrupamentoComplementoPadroes.get( 1 ));
        if(action==3){ // fazer verificacao do agrupamento,  inserir novo se nao houver
            if(tipoAgrupamentoComplementoSelecionado == null ){
                try { // cria o agrupamento
                    tipoAgrupamentoComplemento.setIdTipoAgrupamentoComplemento(0);
                    this.tipoAgrupamentoComplemento.setVendedor(usuarioLogado.getUsuario().getVendedor());
                    this.tipoAgrupamentoComplemento = produtoComplementoBO.save(tipoAgrupamentoComplemento);
                    obj.setTipoAgrupamentoComplemento(tipoAgrupamentoComplemento);
                    if(!listaTipoAgrupamentoComplemento.contains(tipoAgrupamentoComplemento))
                        listaTipoAgrupamentoComplemento.add(tipoAgrupamentoComplemento);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{ // optou por um ja existente
                obj.setTipoAgrupamentoComplemento(tipoAgrupamentoComplementoSelecionado);
            }
        }
        super.save();
        this.setTipoAgrupamentoComplementoSelecionado(null);
        this.setTipoAgrupamentoComplemento(new TipoAgrupamentoComplemento());
    }

    public void setProdutocomplemento(ProdutoComplemento pc){
        super.setObj(pc);
        this.tipoAgrupamentoComplementoSelecionado = pc.getTipoAgrupamentoComplemento();
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
