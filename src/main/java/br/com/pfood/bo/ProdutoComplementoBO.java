/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo;

import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import br.com.pfood.model.TipoAgrupamentoComplemento;
import br.com.pfood.model.Vendedor;
import java.util.List;

/**
 *
 * @author r.palazzio
 */

public interface ProdutoComplementoBO  extends GenericBO{
    public List<TipoAgrupamentoComplemento> getTipoComplementoByVendor(Vendedor vendor) throws Exception;
    
}
