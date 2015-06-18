package br.com.pfood.mb.imp;


import br.com.pfood.bo.UsuarioBO;
import br.com.pfood.enumerated.SituacaoEnum;
import br.com.pfood.model.Usuario;
import br.com.pfood.qualifier.Bundle;
import br.com.pfood.util.Encrypt;
import br.com.pfood.util.HttpUtil;
import br.com.pfood.util.ObjectUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/* Ricardo Palazzio
 *
 */
@Named(value = "loginMB")
@RequestScoped
public class LoginMB extends GenericMBImp<Usuario> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8170667590974977058L;
    private String usuario = "";
    private String senha = "";
    @Inject
    private UsuarioBO usuarioBO;
    @Inject
    @Bundle(tipo = "mensagens")
    private transient ResourceBundle bundleMenssagens;
    @Inject
    @Bundle(tipo = "urlServico")
    private transient ResourceBundle bundleServico;
    @Inject    
    private UsuarioLogadoMB usuarioLogadoMB;
    @Inject
    private HttpUtil httpUtil;
    
    @PostConstruct
    public void init() {
        super.init(usuarioBO);
    }

    public ResourceBundle getBundleMenssagens() {
        return bundleMenssagens;
    }

    public void setBundleMenssagens(ResourceBundle bundleMenssagens) {
        this.bundleMenssagens = bundleMenssagens;
    }

    public ResourceBundle getBundleServico() {
        return bundleServico;
    }

    public void setBundleServico(ResourceBundle bundleServico) {
        this.bundleServico = bundleServico;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public HttpUtil getHttpUtil() {
        return httpUtil;
    }
    
    public void setHttpUtil(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }
    
    public void logar() {
        obj = new Usuario();
        obj = ObjectUtil.preparaObjetoParaBusca(obj);
        obj.setUsuario(usuario);
        obj.setSenha(Encrypt.criptografarSenhaUsuario(senha));
        obj = usuarioBO.getPorAtributosUnicos(obj);

        if (obj != null) {
            if (obj.getSituacao().equals(SituacaoEnum.I) ) {
                messageUtil.addMenssageError(bundleMenssagens.getString("usuarioInvalido"));
                return;
            }
            
            try {
                usuarioLogadoMB.setUsuario(obj);
                usuarioLogadoMB.setUrlServico(bundleServico.getString("pfoodServiceImage"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("../protected/homeuser.jsf");                
            } catch (IOException e) {
                e.printStackTrace();
            }            
        } else {
            messageUtil.addMenssageError(bundleMenssagens.getString("usuarioInvalido"));
        }
        
    }
    
}
