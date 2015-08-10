package br.com.pfood.util;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatorUtil {
	
	public static boolean validaCNPJ(String strCNPJ) {
	    int iSoma = 0, iDigito;
	    char[] chCaracteresCNPJ;
	    String strCNPJ_Calculado;
	 
	    if (! strCNPJ.substring(0,1).equals("")){
	        try{
	            strCNPJ=strCNPJ.replace('.',' ');
	            strCNPJ=strCNPJ.replace('/',' ');
	            strCNPJ=strCNPJ.replace('-',' ');
	            strCNPJ=strCNPJ.replaceAll(" ","");
	            strCNPJ_Calculado = strCNPJ.substring(0,12);
	            if ( strCNPJ.length() != 14 ) return false;
	            chCaracteresCNPJ = strCNPJ.toCharArray();
	            for(int i = 0; i < 4; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48 ) * (6 - (i + 1)) ;
	                }
	            }
	            for( int i = 0; i < 8; i++ ) {
	                if ((chCaracteresCNPJ[i+4]-48 >= 0) && (chCaracteresCNPJ[i+4]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+4] - 48 ) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	               /* Segunda parte */
	            iSoma = 0;
	            for (int i = 0; i < 5; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1)) ;
	                }
	            }
	            for (int i = 0; i < 8; i++) {
	                if ((chCaracteresCNPJ[i+5]-48 >= 0) && (chCaracteresCNPJ[i+5]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+5] - 48) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	            return strCNPJ.equals(strCNPJ_Calculado);
	        } catch (Exception e) {
	            return false;
	        }
	    } else return false;
	}
	
	public static boolean verificaEmail(String pEMail) {
		String eMail = pEMail;
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(eMail);

		if (eMail.length() > 0) {
			boolean matchFound = m.matches();
			if (!matchFound) {
				return	false;
			}
		}
		return	true;
	}
	
	
    public static boolean validaCPF(String strCpf){ // formato XXX.XXX.XXX-XX    
        
        if (! strCpf.substring(0,1).equals("")){    
            try{    
                boolean validado = true;    
                int     d1, d2;    
                int     digito1, digito2, resto;    
                int     digitoCPF;    
                  
                String  nDigResult;    
                strCpf = strCpf.replace('.',' ');    
                strCpf = strCpf.replace('-',' ');    
                strCpf = strCpf.replaceAll(" ","");    
                d1 = d2 = 0;    
                digito1 = digito2 = resto = 0;    
                    
                for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {    
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();    
                        
                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.    
                    d1 = d1 + ( 11 - nCount ) * digitoCPF;    
                        
                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.    
                    d2 = d2 + ( 12 - nCount ) * digitoCPF;    
                }    
                    
                //Primeiro resto da divis�o por 11.    
                resto = (d1 % 11);    
                    
                //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.    
                if (resto < 2)    
                    digito1 = 0;    
                else    
                    digito1 = 11 - resto;    
                    
                d2 += 2 * digito1;    
                    
                //Segundo resto da divis�o por 11.    
                resto = (d2 % 11);    
                    
                //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.    
                if (resto < 2)    
                  
                    digito2 = 0;    
                  
                else    
                    digito2 = 11 - resto;    
                    
                //Digito verificador do CPF que est� sendo validado.    
                String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());    
                    
                //Concatenando o primeiro resto com o segundo.    
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);    
                    
                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.    
                return nDigVerific.equals(nDigResult);    
                  
            }catch (Exception e){    
                System.err.println("Erro !"+e);    
                  
                return false;    
            }    
        }else return false;    
    } 



	
	
	
	
	
}
