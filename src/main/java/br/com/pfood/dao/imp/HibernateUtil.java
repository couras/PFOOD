/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.dao.imp;

import br.com.pfood.model.Categoria;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.Estado;
import br.com.pfood.model.FormaPagamento;
import br.com.pfood.model.GrupoProduto;
import br.com.pfood.model.Imagem;
import br.com.pfood.model.ImagemProduto;
import br.com.pfood.model.ImagemVendedor;
import br.com.pfood.model.Pais;
import br.com.pfood.model.Pessoa;
import br.com.pfood.model.Produto;
import br.com.pfood.model.ProdutoComplemento;
import br.com.pfood.model.Usuario;
import br.com.pfood.model.Vendedor;
import br.com.pfood.model.VendorPerfil;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Ricardo
 */
@ApplicationScoped
public class HibernateUtil {

    private static HashMap<String, SessionFactory> mapaSessao = new HashMap<String, SessionFactory>();
    private static ResourceBundle bundle = ResourceBundle.getBundle("dbServer");
    @Inject
    private Logger logger;

    private static synchronized void criar(String nomeBase) {
        try {

            Configuration conf = new Configuration();

//            conf.setProperty("hibernate.connection.datasource", bundle.getString("hibernate.connection.url") + nomeBase + "");
//            System.out.println(bundle.getString("hibernate.connection.url") + nomeBase + "");
//            conf.setProperty("hibernate.dialect", bundle.getString("hibernate.dialect"));
//            conf.setProperty("hibernate.cache.use_second_level_cache", bundle.getString("hibernate.cache.use_second_level_cache"));

//            conf.setProperty("hibernate.show_sql", bundle.getString("hibernate.show_sql"));
//            conf.setProperty("hibernate.format_sql", bundle.getString("hibernate.show_sql"));
           conf.setProperty("hibernate.hbm2ddl.auto" ,"update");
            
            
            
//            
       conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pfood"); 
        conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");      
        conf.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");                                                                            
        conf.setProperty("hibernate.connection.username", "root");   
        conf.setProperty("hibernate.connection.password", "root");


        
        conf.setProperty("hibernate.show_sql", "true");
        conf.setProperty("hibernate.format_sql", "true");
            
            
            
            
            
            
            
            ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties())
                    .build();

       
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
            conf.addAnnotatedClass(VendorPerfil.class);
            conf.addAnnotatedClass(ProdutoComplemento.class);
            conf.addAnnotatedClass(ImagemProduto.class);
            conf.addAnnotatedClass(ImagemVendedor.class);
            
          
            SessionFactory sessionFactory = conf.buildSessionFactory(registry);
            mapaSessao.put(nomeBase, sessionFactory);

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(String nomeBase) {
        SessionFactory sf = mapaSessao.get(nomeBase);
        if (sf == null) { // se nao tiver sf dessa base criar.
            criar(nomeBase);
            sf = mapaSessao.get(nomeBase);
        }
        return sf;
    }

}
