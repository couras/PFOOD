/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.dao;

import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import java.util.List;

/**
 *
 * @author r.palazzio
 */

public interface ProdutoDAO extends GenericDAO{
    
    public List<ProdutoComplemento> listaComplementos(Produto produto , ProdutoComplementoTipoEnum tipo);
}
