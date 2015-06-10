/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb;

import br.com.pfood.bo.GenericBO;
import java.io.Serializable;


/**
 *
 * @author r.palazzio
 */
public interface GenericMB {
    
    public <T  extends GenericBO> void init(T genericBO);
    
    public <T>  void save();

    public <T>  void remove();

    public <T,PK extends Serializable> void getById(PK  pk);

    public <T>  void getAll();
    
}
