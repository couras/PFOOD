/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;

import br.com.pfood.produces.BundleProdutor;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;

import javax.enterprise.inject.Produces;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author r.palazzio
 */
@Named(value = "localeControlerMB")
@SessionScoped
public class LocaleControlerMB implements Serializable{

        
        private Locale currentLocale ;
        @Inject 
        private Instance<BundleProdutor> produtor;
    
        
        @PostConstruct
        public void init(){
            currentLocale =  new Locale("pt", "BR");
        }
        
        @Produces
        public Locale produtorLocale(){
            return this.currentLocale;
        }
        
        public void englishLocale() {
            UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
            currentLocale = Locale.US;
            viewRoot.setLocale(currentLocale);
            produtor.get().zeraLanguage();
        }

        public void portugueseLocale() {
            UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
            currentLocale = new Locale("pt", "BR");
            viewRoot.setLocale(currentLocale);
            produtor.get().zeraLanguage();
        }
        
        public void spanishLocale() {
            UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
            currentLocale = new Locale("es", "ES");
            viewRoot.setLocale(currentLocale);
            produtor.get().zeraLanguage();
        }
        
        
        public Locale getCurrentLocale() {
            return currentLocale;
        }

        public void setCurrentLocale(Locale currentLocale) {
            this.currentLocale = currentLocale;
        }

       
   }


