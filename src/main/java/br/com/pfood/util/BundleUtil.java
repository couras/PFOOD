/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.util;

import java.util.ResourceBundle;

/**
 *
 * @author r.palazzio
 */
public class BundleUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("dbnames");

    
    public static String getBase(String chave) {
        String value = null;
        try {
            value = bundle.getString(chave);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    

}
