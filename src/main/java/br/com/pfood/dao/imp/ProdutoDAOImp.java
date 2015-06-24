/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.dao.imp;

import br.com.pfood.dao.ProdutoDAO;
import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Typed;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author r.palazzio
 */
@Typed(ProdutoDAO.class)
public class ProdutoDAOImp extends GenericDAOImp implements ProdutoDAO , Serializable{

    @Override
    public List<ProdutoComplemento> listaComplementos(Produto produto, ProdutoComplementoTipoEnum tipo) {
            
        Criteria c  =  super.getSession().createCriteria(ProdutoComplemento.class , "pc")
                .add(Restrictions.eq("pc.produto", produto))
                .add(Restrictions.eq("pc.tipo", tipo.getTipo()))
                .addOrder(Order.asc("pc.sequencia"));
        if(c.list()!=null && !c.list().isEmpty()){
            return c.list();
        }else{
            return new ArrayList<ProdutoComplemento>();
        }
        
    }
    
}
