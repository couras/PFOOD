/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.util;

import java.util.regex.Pattern;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author r.palazzio
 */
public class UsuarioUtil {
    	/**
	 * Busca o nome da base atraves da url de acesso.
	 * atarves do primeiro nome da url busca no Bundle de bases o nome da base referente
	 * @param url
	 * @return o nome da base
	 */
        @Inject HttpUtil httpUtil;
	public  String getDataBase(){
		String[] vector  = (String[]) httpUtil.getHttpRequest().getServerName().split(Pattern.quote("."));	
		if (vector[0].equals("localhost") || vector[0].equals("192")) 
			return BundleUtil.getBase("desenvolvimento");
		else
			return BundleUtil.getBase(vector[0]);
	}
      
        
}
