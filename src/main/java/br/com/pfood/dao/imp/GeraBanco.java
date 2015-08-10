package br.com.pfood.dao.imp;

import br.com.pfood.model.Categoria;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Estado;
import br.com.pfood.model.FormaPagamento;
import br.com.pfood.model.GrupoProduto;
import br.com.pfood.model.Imagem;
import br.com.pfood.model.Pais;
import br.com.pfood.model.Pessoa;
import br.com.pfood.model.Produto;
import br.com.pfood.model.Usuario;
import br.com.pfood.model.Vendedor;
import br.com.pfood.model.VendedorPerfil;
import java.util.ResourceBundle;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class GeraBanco {


	
	public static void main(String[] args) {
		Configuration conf = new Configuration();

        conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pfood"); 
        conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");      
        conf.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");                                                                            
        conf.setProperty("hibernate.connection.username", "root");   
        conf.setProperty("hibernate.connection.password", "Pfood2015");
        
        conf.setProperty("hibernate.hbm2ddl.auto", "create");
        

        
        conf.setProperty("hibernate.show_sql", "true");
        conf.setProperty("hibernate.format_sql", "true");
        
            conf.addAnnotatedClass(Cidade.class);
            conf.addAnnotatedClass(Estado.class);
            conf.addAnnotatedClass(Pais.class);
            conf.addAnnotatedClass(Pessoa.class);
            conf.addAnnotatedClass(Vendedor.class);
            conf.addAnnotatedClass(Cliente.class);
            conf.addAnnotatedClass(Usuario.class);
            conf.addAnnotatedClass(FormaPagamento.class);
            conf.addAnnotatedClass(Categoria.class);
            conf.addAnnotatedClass(Complemento.class);
            conf.addAnnotatedClass(GrupoProduto.class);
            conf.addAnnotatedClass(Imagem.class);
            conf.addAnnotatedClass(Produto.class);
            conf.addAnnotatedClass(VendedorPerfil.class);
        
        SchemaExport se = new SchemaExport(conf);
        se.setOutputFile("E:/DDL.sql");
        se.create(true, true);
	}
}
