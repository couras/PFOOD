/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo.imp;


import br.com.pfood.bo.ProdutoBO;
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
@Typed(ProdutoBO.class)
public class ProdutoBOImp  extends GenericBOImp implements ProdutoBO , Serializable{

    @Inject transient Logger logger;
    @Inject ProdutoDAO pdao;
    @PostConstruct
    public void init(){
        logger.debug("ProdutoBO construido");
    }
    
    @PreDestroy
    public void destroy(){
        logger.debug("ProdutoBO destruido");
    }

    @Override
    public List<ProdutoComplemento> listaComplementosPadrao(Produto produto) {
      return pdao.listaComplementos(produto, ProdutoComplementoTipoEnum.PADRAO);
    }

    @Override
    public List<ProdutoComplemento> listaComplementosAdicional(Produto produto) {
       return pdao.listaComplementos(produto, ProdutoComplementoTipoEnum.ADICIONAL);
    }

    @Override
    public List<ProdutoComplemento> listaComplementosOpcional(Produto produto) {
        return pdao.listaComplementos(produto, ProdutoComplementoTipoEnum.OPCIONAL);
    }

}
