/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;

import br.com.pfood.bo.GenericBO;
import br.com.pfood.mb.GenericMB;
import br.com.pfood.util.CdiUtils;
import br.com.pfood.util.MessageUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author r.palazzio
 */
public abstract class GenericMBImp<T> implements GenericMB, Serializable {

    private GenericBO genericBO;
    T obj;
    private List<T> lista;
    private Class<T> classe;
    @Inject
    private transient Logger logger;
    @Inject
    protected MessageUtil messageUtil;
    protected BeanManager beanManager;

    @Inject @Any private Event<List<T>> eventList;

    public Event<List<T>> getEventList() {
        return eventList;
    }

    public void setEventList(Event<List<T>> eventList) {
        this.eventList = eventList;
    }

 
    public Class<T> getClasse() {
        return classe;
    }

    public void setClasse(Class<T> classe) {
        this.classe = classe;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }

    public void setMessageUtil(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public void init(GenericBO bo) {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            classe = (Class) parameterizedType.getActualTypeArguments()[0];
            obj = classe.newInstance();
            lista = new ArrayList<T>();
            this.genericBO = bo;
            this.beanManager = new CdiUtils().getBeanManager();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public void setGenericBO(GenericBO genericBO) {
        this.genericBO = genericBO;
    }

    @Override
    public <T> void save() {
        try {
            this.obj = genericBO.save(obj);
            if (this.lista != null && this.lista.isEmpty()) {
                lista.add(obj);
            } else {
                int index = lista.indexOf(obj);
                lista.remove(obj);
                if (index != -1) {
                    lista.add(index, obj);
                } else {
                    lista.add(obj);
                }
            }
            eventList.fire(lista);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            messageUtil.addMenssageError(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public <T> void remove() {
        try {

            if (this.lista != null && !this.lista.isEmpty()) {
                int index = lista.indexOf(obj);
                genericBO.remove(obj);
                lista.remove(index);
                this.obj = classe.newInstance();
            } else {
                genericBO.remove(obj);
            }
           eventList.fire(lista);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            messageUtil.addMenssageError(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public <T> void remove(T t) {
        try {
            obj = classe.cast(t);
            this.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void getAll() {
        this.lista = genericBO.getAll(classe);
         eventList.fire(lista);
    }

    @Override
    public <T, PK extends Serializable> void getById(PK pk) {
        this.obj = genericBO.getById(classe, pk);
    }

    @Override
    public void novo() {
        try {
            this.obj = classe.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
