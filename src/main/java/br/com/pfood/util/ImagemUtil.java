package br.com.pfood.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagemUtil {
	
	public static void redimenImagem(String novoCaminhoImg, String caminhoImg, Integer imgLargura, Integer imgAltura, String extencao) throws IOException {  
        BufferedImage imagem = ImageIO.read(new File(caminhoImg));  
          
        Double novaImgLargura = (double) imagem.getWidth();  
        Double novaImgAltura = (double) imagem.getHeight();  
  
        Double imgProporcao = null;  
       
        if (novaImgLargura > novaImgAltura) {  
            imgProporcao = (novaImgAltura / novaImgLargura);  
            
            novaImgLargura = (double) imgLargura;  
            novaImgAltura = (novaImgLargura * imgProporcao);  
      
        } else if (novaImgAltura > novaImgLargura) {  
            imgProporcao = (novaImgLargura/novaImgAltura );  
            novaImgAltura = (double) imgAltura;  
            novaImgLargura = (novaImgAltura * imgProporcao);  

        } else if (novaImgLargura.equals(novaImgAltura)) {
        	novaImgAltura = (double)imgAltura;
        	novaImgLargura = (double)imgLargura;
        }
  
        BufferedImage novaImagem = null;
        
        if (extencao.equalsIgnoreCase("PNG") || extencao.equalsIgnoreCase("GIF")) {
        	novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_ARGB);
	    	Graphics2D g = (Graphics2D) novaImagem.getGraphics();  
	        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 100), 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);  
	        ImageIO.write(novaImagem, "PNG", new File(novoCaminhoImg));
	        g.dispose();
	        g = null;
        } else {
        	novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        	Graphics2D g = (Graphics2D) novaImagem.getGraphics();  
            g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 100), 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);  
            ImageIO.write(novaImagem, "JPG", new File(novoCaminhoImg)); 
            g.dispose();
            g = null;
        }
    }
	

	
    
}
