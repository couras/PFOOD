/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pfood.mb.imp;

import br.com.pfood.bo.ClienteBO;
import br.com.pfood.enumerated.SituacaoEnum;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.Usuario;
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
@Named(value = "clienteMB")
@ViewScoped
public class ClienteMB extends GenericMBImp<Cliente>{
    
    @Inject ClienteBO clienteBO;
    private Usuario user  = null;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    @PostConstruct
    public void   init(){
        super.init(clienteBO);
        user = new Usuario();
    }


    public void save(ActionEvent evt){
        try {
          obj.setPessoa(clienteBO.save(obj.getPessoa()));
          obj.setIdCliente(obj.getPessoa().getIdPessoa());
          user.setCliente(clienteBO.save(obj));
          user.setUsuario(obj.getPessoa().getEmail());
          user.setSenha(Encrypt.criptografarSenhaUsuario(user.getSenha()));
          user.setSituacao(SituacaoEnum.A);
          clienteBO.save(user);
          
            
            RequestContext.getCurrentInstance().execute("closeDialogCli.click();");
        } catch (Exception ex) {
            messageUtil.addMenssageError(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
