/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo.imp;


import br.com.pfood.bo.GrupoProdutoBO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author r.palazzio
 */
@Typed(GrupoProdutoBO.class)
public class GrupoProdutoBOImp  extends GenericBOImp implements GrupoProdutoBO , Serializable{

    @Inject transient Logger logger;
    @PostConstruct
    public void init(){
        logger.debug("GrupoProdutoBO construido");
    }
    
    @PreDestroy
    public void destroy(){
        logger.debug("GrupoProdutoBO destruido");
    }

}
