/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.VendedorBO;
import br.com.pfood.enumerated.SituacaoEnum;
import br.com.pfood.model.Usuario;
import br.com.pfood.model.Vendedor;
import br.com.pfood.util.Encrypt;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;


/**
 *
 * @author r.palazzio
 */
@Named(value = "vendedorMB")
@ViewScoped
public class VendedorMB extends GenericMBImp<Vendedor>{
    
    @Inject VendedorBO vendedorBO;
    private Usuario user  = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(vendedorBO);
        user = new Usuario();
    }


    public void save(ActionEvent evt){
        try {
          
          if(obj.getPessoa()==null ||obj.getPessoa().getIdPessoa() ==null || obj.getPessoa().getIdPessoa().equals(0)){
            user.setSituacao(SituacaoEnum.T);
          }
          obj.setPessoa(vendedorBO.save(obj.getPessoa()));
          obj.setIdVendedor(obj.getPessoa().getIdPessoa());
          user.setVendedor(vendedorBO.save(obj));
          user.setUsuario(obj.getPessoa().getEmail());
          user.setSenha(Encrypt.criptografarSenhaUsuario(user.getSenha()));
          vendedorBO.save(user);
               
            RequestContext.getCurrentInstance().execute("closeDialogVendor.click();");
        } catch (Exception ex) {
            messageUtil.addMenssageError(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
