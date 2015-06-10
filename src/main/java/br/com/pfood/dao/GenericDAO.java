/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.dao;


import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Typed;
import org.hibernate.criterion.Order;

/**
 *
 * @author r.palazzio
 */

public interface GenericDAO {
    
    public <T extends Object> T save(T entity) throws Exception;

    public <T extends Object> void remove(T entity) throws Exception;

    public <T extends Object , PK extends Serializable> T getById(Class<T> classe, PK pk) throws Exception;

    public <T extends Object> List<T> getAll(Class<T> classe) throws Exception;
    
    /**
     * Recebe um objeto  com os atributos que serão usados
     * na busca preenchidos.
     * objeto deve ser limpo antes pelo metodo ObjetoUtil.preparaObjetoParaBusca(T obj)
     * @param <T>
     * @param obj
     * @return List<T>
     */
    public <T extends Object> List<T> getPorAtributosIguais(T obj, Order order) throws Exception;
    
    /**
     * Recebe um objeto  com os atributos que serão usados
     * na busca preenchidos.
     * objeto deve ser limpo antes pelo metodo ObjetoUtil.preparaObjetoParaBusca(T obj)
     * @param <T>
     * @param obj
     * @return List<T>
     */
    public <T extends Object> List<T> getPorAtributosIguaisOuNull(T obj, Order order) throws Exception;
    /**
     * Recebe um objeto  com os atributos que serão usados
     * na busca preenchidos.
     * objeto deve ser limpo antes pelo metodo ObjetoUtil.preparaObjetoParaBusca(T obj)
     * @param <T>
     * @param obj
     * @return obj
     */
    public <T extends Object> T getPorAtributosUnicos(T obj) throws Exception;
    
    public int buscaProximoCodigo(Class classe) throws Exception;
}
