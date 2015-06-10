/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;
import javax.validation.constraints.NotNull;

/**
 *
 * @author r.palazzio
 */
@Target({TYPE, FIELD, METHOD, PARAMETER}) 
@Retention(RetentionPolicy.RUNTIME) 
@Qualifier
public @interface  Bundle {
    /**
     * define o tipo(nome) do bundle. ex: label, mensagens, etc...
     * @return 
     */
    @NotNull
    String tipo() ;
}
