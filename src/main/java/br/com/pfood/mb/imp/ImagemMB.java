/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ImagemBO;
import br.com.pfood.model.Imagem;
import br.com.pfood.model.Usuario;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;




/**
 *
 * @author r.palazzio
 */
@Named(value = "imageMB")
@SessionScoped
public class ImagemMB extends GenericMBImp<Imagem>{
    
    @Inject ImagemBO imageBO;
    private Usuario user  = null;

    public ImagemBO getImageBO() {
        return imageBO;
    }

    public void setImageBO(ImagemBO imageBO) {
        this.imageBO = imageBO;
    }

    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(imageBO);
        user = new Usuario();
    }


   private Part file;

public void validateFile(FacesContext ctx,
                         UIComponent comp,
                         Object value) {
  List<FacesMessage> msgs = new ArrayList<FacesMessage>();
  Part file = (Part)value;
  if (file.getSize() > 1024) {
    msgs.add(new FacesMessage("file too big"));
  }
  if (!"text/plain".equals(file.getContentType())) {
    msgs.add(new FacesMessage("not a text file"));
  }
  if (!msgs.isEmpty()) {
    throw new ValidatorException(msgs);
  }
}
  
  
  
  public Part getFile() {
    return file;
  }
 
  public void setFile(Part file) {
    this.file = file;
    System.out.print("Arquivo no MB: " + file.getName());
  }
}
