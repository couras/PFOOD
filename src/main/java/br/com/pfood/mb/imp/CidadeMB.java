/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.CidadeBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Estado;
import br.com.pfood.util.ObjectUtil;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.criterion.Order;


/**
 *
 * @author r.palazzio
 */
@Named(value = "cidadeMB")
@ApplicationScoped
public class CidadeMB extends GenericMBImp<Cidade>{
    
    @Inject CidadeBO cidadeBO;
    
    @PostConstruct
    public void   init(){
        super.init(cidadeBO);
        Cidade c = new Cidade();
        ObjectUtil.preparaObjetoParaBusca(c);
        Estado e  = new Estado();
        e.setIdEstado(1);
        c.setEstado(e);
        super.setLista(cidadeBO.getPorAtributosIguais(c, Order.asc("nome")));
    }

}
