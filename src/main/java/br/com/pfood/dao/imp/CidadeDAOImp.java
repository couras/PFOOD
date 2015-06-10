/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.dao.imp;

import br.com.pfood.dao.CidadeDAO;
import java.io.Serializable;
import javax.enterprise.inject.Typed;

/**
 *
 * @author r.palazzio
 */
@Typed(CidadeDAO.class)
public class CidadeDAOImp extends GenericDAOImp implements CidadeDAO , Serializable{
    
}
