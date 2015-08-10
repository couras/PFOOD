package  br.com.pfood.servlets;

import br.com.pfood.util.AppUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pfood.util.UsuarioUtil;
import java.util.regex.Pattern;

@WebServlet(name = "DownlaodServlet", urlPatterns = {"/DownSe"})
public class DownloadArquivos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DownloadArquivos() {
        super();
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		

                String nomeArquivo = request.getParameter("inf");
                
                // "user|dir|nomeArquivo"     
                String params[]  = nomeArquivo.split(Pattern.quote("-"));
		if(params.length <3)
                    return;
	
		String dir  = AppUtil.getDirFilesVendor() +params[0]+"/"+params[1]+"/"+params[2];
		

		File file = new File(dir);
		if(!file.exists())
                    return;
                
                FileInputStream is = null;
                
		is = new FileInputStream(file);          
				
		
		byte[] bytes = new byte[1024];
		
		if (is != null) {
			int bytesReady;	
			while ((bytesReady = is.read(bytes)) != -1) {
				out.write(bytes,0,bytesReady);
			}
			
			out.flush();
			is.close();
			is = null;
		}
		
		out.close();
		out = null;
		bytes = null;
	}

}