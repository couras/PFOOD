/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {

    public static String tratarCaracterEspecial(String str) {
        str = str.replaceAll("[ÂÀÁÄÃA]", "A");
        str = str.replaceAll("[âãàáä]", "a");
        str = str.replaceAll("[ÊÈÉËE]", "E");
        str = str.replaceAll("[êèéë]", "e");
        str = str.replaceAll("[ÎÍÌÏI]", "I");
        str = str.replaceAll("[îíìï]", "i");
        str = str.replaceAll("[ÔÕÒÓÖO]", "O");
        str = str.replaceAll("[ôõòóö]", "o");
        str = str.replaceAll("[ÛÙÚÜU]", "U");
        str = str.replaceAll("[ûúùü]", "u");
        str = str.replaceAll("[ÇC]", "C");
        str = str.replaceAll("ç", "c");
        str = str.replaceAll("[ýÿ]", "y");
        str = str.replaceAll("Ý", "Y");
        str = str.replaceAll("ñ", "n");
        str = str.replaceAll("Ñ", "n");
        str = str.replaceAll("!", "");
        str = str.replaceAll("&", "");
        str = str.replaceAll("\\$", "");
        str = str.replaceAll("\\ª", "");
        str = str.replaceAll("\\º", "");
        str = str.replaceAll("\\?", "");
        str = str.replaceAll("\\)", "_");
        str = str.replaceAll("\\(", "_");
        str = str.replaceAll("\\|", "_");
        str = str.replaceAll("\\¦", "_");
        str = str.replaceAll("\\®", "_");
        str = str.replaceAll("\\©", "_");

        return str;
    }

    public static String tratarCaracterEespacaoBranco(String text) {

        String stg = text;

        while (stg.contains(" ")) {
            stg = stg.replaceAll(" ", "_");
        }

        stg = stg.replaceAll("[ÂÀÁÄÃA]", "A");
        stg = stg.replaceAll("[âãàáä]", "a");
        stg = stg.replaceAll("[ÊÈÉËE]", "E");
        stg = stg.replaceAll("[êèéë]", "e");
        stg = stg.replaceAll("[ÎÍÌÏI]", "I");
        stg = stg.replaceAll("[îíìï]", "i");
        stg = stg.replaceAll("[ÔÕÒÓÖO]", "O");
        stg = stg.replaceAll("[ôõòóö]", "o");
        stg = stg.replaceAll("[ÛÙÚÜU]", "U");
        stg = stg.replaceAll("[ûúùü]", "u");
        stg = stg.replaceAll("[ÇC]", "C");
        stg = stg.replaceAll("ç", "c");
        stg = stg.replaceAll("[ýÿ]", "y");
        stg = stg.replaceAll("Ý", "Y");
        stg = stg.replaceAll("ñ", "n");
        stg = stg.replaceAll("Ñ", "n");
        stg = stg.replaceAll("!", "");
        stg = stg.replaceAll("&", "");
        stg = stg.replaceAll("\\$", "");
        stg = stg.replaceAll("\\ª", "");
        stg = stg.replaceAll("\\º", "");
        stg = stg.replaceAll("\\?", "");
        stg = stg.replaceAll("-", "_");
        stg = stg.replaceAll("\\)", "_");
        stg = stg.replaceAll("\\(", "_");
        stg = stg.replaceAll("\\|", "_");
        stg = stg.replaceAll("\\¦", "_");
        stg = stg.replaceAll("\\®", "_");
        stg = stg.replaceAll("\\©", "_");

        return stg;
    }
    /*
     public static String trataCaracterCNPJCPF(String cpfCnpj){
		
     cpfCnpj  = cpfCnpj.replace(Pattern.quote("\\") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote("/") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote(".") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote(",") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote("-") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote("_") , "");
     cpfCnpj  = cpfCnpj.replace(Pattern.quote(" ") , "");
     return cpfCnpj;
     }
     */

    public static String removeHTML(String htmlString) {
        // Remove HTML tag from java String    
        String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

        // Remove Carriage return from java String
        noHTMLString = noHTMLString.replaceAll("\r", ""); // QUEBRA DE LINHA

        // Remove New line from java string and replace html break
        noHTMLString = noHTMLString.replaceAll("\n", " ");
        noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
        return noHTMLString;
    }

    public static String getMD5(String senha) {
        String md5 = "";
        try {
            md5 = DigestUtils.md5Hex(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return md5;
    }

    public static String removeCaracterEspecial(String content) {
        content = content.replaceAll("(\\r|\\n|\\t)", "");

        return content;
    }

    public static String removeEspacosEmBranco(String content) {
        if (content != null) {
            content = content.replaceAll("(\\s)", "");
        }

        return content;
    }

    public static String removeQuebraDeLinha(String content) {
        if (content != null) {
            content = content.replaceAll("(\\n|\\r)", "").trim();
        }

        return content;
    }

    public static String limpaCpfCnpj(String pCpfCnpj) {
        String cpfCnpj = null;

        if (pCpfCnpj != null) {
            cpfCnpj = pCpfCnpj.replaceAll("[^0-9A-Za-z]", "");
        }

        return cpfCnpj;
    }

}
