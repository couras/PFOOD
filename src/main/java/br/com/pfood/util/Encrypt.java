package br.com.pfood.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encrypt {

//	public static String  desCrypt(String senha) {
//		String senhaCodificada = "";
//	    
//		
//	    for (int i=0; i<senha.length(); i++) {
//	        senhaCodificada = senhaCodificada +"." ;
//	        int caracter = senha.charAt(i);
//	        senhaCodificada = senhaCodificada + caracter + ((i+1) * (i+1));
//	    }
//	    
//	    return senhaCodificada;
//	}
	
	
	
	public  static String criptografarSenhaUsuario(String senha){
		String criptografia  =  senha;
//			for(int i = 0 ;  i <= 5 ; i++){
				criptografia = DigestUtils.md5Hex(criptografia);
//			}
				
		return criptografia;
	}
	
}
