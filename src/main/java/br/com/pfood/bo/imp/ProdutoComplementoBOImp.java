/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo.imp;


import br.com.pfood.bo.ComplementoBO;
import br.com.pfood.bo.ProdutoComplementoBO;
import br.com.pfood.dao.ProdutoDAO;
import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author r.palazzio
 */
@Typed(ProdutoComplementoBO.class)
public class ProdutoComplementoBOImp  extends GenericBOImp implements ProdutoComplementoBO , Serializable{

    @Inject transient Logger logger;

 

}
