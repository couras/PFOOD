/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.dao.imp;

import br.com.pfood.dao.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

/**
 *
 * @author r.palazzio
 */
public class GenericDAOImp implements GenericDAO, Serializable {

    public GenericDAOImp() {
    }

    @Inject
    private Session session;

    @Override
    public <T extends Object> T save(T entity) throws Exception {
        session.saveOrUpdate(entity);
        return (T) entity;
    }

    @Override
    public <T extends Object> void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public <T extends Object, PK extends Serializable> T getById(Class<T> classe, PK pk) {

        try {
            return (T) session.get(classe, pk);
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public <T extends Object> List<T> getAll(Class<T> classe) {
        return (List<T>) session.createCriteria(classe).list();
    }

    @Override
    public <T extends Object> List<T> getAllLimit(Class<T> classe, Order order, Integer inicio, Integer fim) {
        Criteria c = session.createCriteria(classe);
        if (inicio != null) {
            c.setFirstResult(inicio);
        }
        if (fim != null) {
            c.setMaxResults(fim);
        }
        if (order != null) {
            c.addOrder(order);
        }

        c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);

        return (List<T>) c.list();
    }

    /**
     * Não é obrigatório passar o ORDER, caso receba null vai buscar pelo padrão
     * do banco de dados
     *
     * @param <T>
     * @param obj
     * @param order
     * @return List<T> podendo ser null
     */
    @Override
    public <T extends Object> List<T> getPorAtributosIguais(T obj, Order order) {
        Criteria c = session.createCriteria(obj.getClass());

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if ((f.isAnnotationPresent(Column.class)
                    || f.isAnnotationPresent(ManyToOne.class)
                    || f.isAnnotationPresent(OneToOne.class)) && !f.getType().isPrimitive()) {
                try {
                    Object valor = f.get(obj);
                    if (valor != null) {
                        c.add(Restrictions.eq(f.getName(), valor));
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
        if (order != null) {
            c.addOrder(order);
        }
        return (ArrayList<T>) c.list();
    }

    public <T extends Object> T getPorAtributosUnicos(T obj) throws Exception {
        Criteria c = session.createCriteria(obj.getClass());
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if ((f.isAnnotationPresent(Column.class)
                    || f.isAnnotationPresent(ManyToOne.class)
                    || f.isAnnotationPresent(OneToOne.class)) && !f.getType().isPrimitive()) {
                try {
                    Object valor = f.get(obj);
                    if (valor != null) {
                        c.add(Restrictions.eq(f.getName(), valor));
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
        if (!c.list().isEmpty() && c.list().size() > 1) {
            throw new Exception("Mais de um resultado encontrado para o objeto");
        }
        if (c.list().isEmpty()) {
            return null;
        }
        return (T) c.uniqueResult();
    }

    public Session getSession() {
        return session;
    }

    /**
     * Metodo criado inicialmente para busca de item_tabela_preco. Voce deve
     * preencher o objeto com os atributos a ser buscado. Vai executar uma busca
     * apartir de todos os atributos COM VALOR, onde on valor for igual ao
     * informado ou entao esta null no banco. A busca é apenas pelos atributos
     * que possuem valor, nao em todo os atributos do objeto.
     *
     * @param <T>
     * @param obj
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public <T> List<T> getPorAtributosIguaisOuNull(T obj, Order order) throws Exception {
        Criteria c = session.createCriteria(obj.getClass());

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if ((f.isAnnotationPresent(Column.class)
                    || f.isAnnotationPresent(ManyToOne.class)
                    || f.isAnnotationPresent(OneToOne.class)) && !f.getType().isPrimitive()) {
                try {
                    Object valor = f.get(obj);
                    if (valor != null) {
                        c.add(Restrictions.or(Restrictions.eq(f.getName(), valor), Restrictions.isNull(f.getName())));
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
        if (order != null) {
            c.addOrder(order);
        }
        return (ArrayList<T>) c.list();
    }

    @Override
    public int buscaProximoCodigo(Class classe) throws Exception {

        Field[] fields = classe.getDeclaredFields();
        Criteria c = getSession().createCriteria(classe);
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Id.class)) {
                c.setProjection(Projections.max(f.getName()));
                break;
            }
        }
        c.setResultTransformer(c.DISTINCT_ROOT_ENTITY);
        Integer maximo = (Integer) c.uniqueResult();

        if (maximo == null || maximo == 0) {
            return 1;
        } else {
            return maximo + 1;
        }
    }

}
