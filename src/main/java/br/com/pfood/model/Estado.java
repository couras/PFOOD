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
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "estado",
		uniqueConstraints = {@UniqueConstraint(columnNames={"sigla", "id_pais"})})
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_estado")
	private int idEstado;
	
	@Column(name="nome", length = 60)
	private String nome;
	
	@Column(name ="sigla", length = 10, nullable = false)
	private String sigla;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_pais" ,  foreignKey = @ForeignKey(name="estado_pais_fk"))
	
	private Pais pais;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_inclusao")
	private Date dataInclusao;
	
	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		result = prime * result + idEstado;
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
		Estado other = (Estado) obj;
		if (idEstado != other.idEstado)
			return false;
		return true;
	}

}
