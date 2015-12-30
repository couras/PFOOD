package br.com.pfood.model;

import br.com.pfood.enumerated.SituacaoEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, Comparable<Usuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "usuario", nullable = false)
	private String usuario;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "ultimo_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcesso;

	@Column(name = "sessao")
	private String sessao;

	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao")
	private Date dataInclusao;

	
	@ManyToOne
	@JoinColumn(name="id_vendedor" , foreignKey = @ForeignKey(name="usuario_vendedor_fk"))
	private Vendedor vendedor;
        
        
        @ManyToOne
	@JoinColumn(name="id_cliente" , foreignKey = @ForeignKey(name="usuario_cliente_fk"))
	private Cliente cliente;
	
	
	public Usuario() {
		this.situacao = SituacaoEnum.A;
	}

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

        



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return this.usuario;
	}

	@Override
	public int compareTo(Usuario usu) {
		return usuario.compareTo(usu.getUsuario());
	}
	
}
