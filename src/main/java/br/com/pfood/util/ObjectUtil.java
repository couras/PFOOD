/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author r.palazzio
 */
public class ObjectUtil {
 
    /**
     * Limpa todos os atributos do objeto para busca,
     * anotado com @Column @ManyToOne @OneToOne.
     * Atenção: O objeto não pode ter atributos primitivos.
     * ex: int não funciona , Integer sim.
     * @param <T>
     * @param obj
     * @return o mesmo objeto
     */
    public static <T> T preparaObjetoParaBusca(T obj){
        if(obj==null){
            try {
                obj =(T) obj.getClass().newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if(f.isAnnotationPresent(Column.class) 
                    || f.isAnnotationPresent(ManyToOne.class)
                    || f.isAnnotationPresent(OneToOne.class)){
                try {
                    if( (f.getType() instanceof Serializable || f.getType().isEnum()) && !f.getType().isPrimitive() )
                        f.set(obj, null);   
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return obj;
        }

    }
