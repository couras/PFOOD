/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo.imp;

import br.com.pfood.bo.GenericBO;
import br.com.pfood.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author r.palazzio
 */
public abstract class GenericBOImp implements GenericBO , Serializable{


    @Inject
    private Session session;
    @Inject
    private GenericDAO dao;
    @Inject
    private transient Logger logger;
            
    @Override
    public <T extends Object> T save(T entity) throws Exception{
       try{
           dao.save(entity);
           session.flush();
       }catch(Exception e){
           logger.error(e.getMessage());
           throw e;
       }
       return entity;
    }

    @Override
    public <T> void remove(T entity) throws Exception {
        try {
            dao.remove(entity);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public <T extends Object, PK extends Serializable> T getById(Class<T> classe, PK pk) {
        try {
            return dao.getById(classe, pk);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public <T extends Object> List<T> getAll(Class<T> classe) {
        try {
            return dao.getAll(classe);
        } catch (Exception ex) {
            return null;
        }
    }
   
    @Override
    public <T extends Object> List<T> getPorAtributosIguais(T obj, Order order){
        List<T> list = null;
        try {
             list = dao.getPorAtributosIguais(obj, order);
        } catch (Exception ex) {
           logger.error(ex);
           ex.printStackTrace();
        }
        return list;
    }
    
   @Override
    public <T extends Object> T getPorAtributosUnicos(T obj){
        
        try {
            obj= dao.getPorAtributosUnicos(obj);
        } catch (Exception ex) {
           logger.error(ex); 
        }
        return obj;
    } 
    
    
    @Override
    public int buscaProximoCodigo(Class classe){
        Integer i  = 0; 
           try{         
               i = dao.buscaProximoCodigo(classe);
           }catch(Exception e){
               e.printStackTrace();
               logger.fatal(e);
           }
        return i;
    }
   
}
