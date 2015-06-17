/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.bo;


import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author r.palazzio
 */
public interface GenericBO extends Serializable{
    
    public <T extends Object> T save(T entity) throws Exception;

    public <T extends Object>  void remove(T entity)throws Exception ;

    public <T extends Object , PK extends Serializable>   T getById(Class<T> classe, PK  pk);

    public <T extends Object>  List<T> getAll(Class<T> classe);
    
    public int buscaProximoCodigo(Class classe);
    
      /**
     * Recebe um objeto  com os atributos que serão usados
     * na busca preenchidos.
     * objeto deve ser limpo antes pelo metodo ObjetoUtil.preparaObjetoParaBusca(T obj)
     * @param <T>
     * @param obj
     * @return List<T>
     */
    public <T extends Object> List<T> getPorAtributosIguais(T obj, Order order) ;
    /**
     * Recebe um objeto  com os atributos que serão usados
     * na busca preenchidos.
     * objeto deve ser limpo antes pelo metodo ObjetoUtil.preparaObjetoParaBusca(T obj)
     * @param <T>
     * @param obj
     * @return obj
     */
    public <T extends Object> T getPorAtributosUnicos(T obj) ;
    
}
