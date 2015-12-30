package br.com.pfood.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "cidade")
public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cidade" )
	private int idCidade;
	
	
	@Column(name="nome", length = 60, nullable = false)
	private String nome;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_estado" , foreignKey = @ForeignKey(name = "cidade_estado_fk"))
	private Estado estado;
	
	@Column(name="cep_basico")
	private String cepBasico;
	
	@Column(name="ddd")
	private String ddd;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_inclusao")
	private Date dataInclusao;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCepBasico() {
        return cepBasico;
    }

    public void setCepBasico(String cepBasico) {
        this.cepBasico = cepBasico;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
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
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCidade;
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
		Cidade other = (Cidade) obj;
		if (idCidade != other.idCidade)
			return false;
		return true;
	}


	
}
