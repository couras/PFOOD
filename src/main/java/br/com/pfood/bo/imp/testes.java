/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.bo.imp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author palazzio
 */
public class testes {
    public static void main(String[] args){
        List<String> ss  = new ArrayList<String>();
        
        String sss  = new String("aaaaaaaaaaa");
        ss.add(sss);
        
        sss = "bbbbbbb";
        
        System.out.println(ss.get(0));
        System.out.print(sss);
    }
}
