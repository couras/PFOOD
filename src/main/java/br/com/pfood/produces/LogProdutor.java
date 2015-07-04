/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.produces;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.apache.log4j.Logger;

/**
 *
 * @author r.palazzio
 */
public class LogProdutor implements Serializable{
    /**
     * produtor responsavel pro produzir objestos Logger do sitema
     * InjectionPoint é uma class do weld que traz os metadados
     * da classe que está injentando a dependencia do Logger.
     * @param ip
     * @return Logger
     */
    @Produces 
    public Logger produtorLogger(InjectionPoint ip){
        return Logger.getLogger( ip.getMember().getDeclaringClass() );
    }
}
