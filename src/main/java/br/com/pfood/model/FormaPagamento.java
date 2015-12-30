package br.com.pfood.model;

import br.com.pfood.enumerated.SituacaoEnum;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forma_pagamento")
	private int idFormaPagamento;
	

	@Column(name = "descricao", length = 20, nullable = false)
	private String descricao;
	
	@Column(name = "situacao", nullable = false)
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_inclusao")
	private Date dataInclusao;
	
        @Column(name = "icon", length = 20, nullable = false)
	private String icon;
        
	public FormaPagamento() {
		situacao = SituacaoEnum.A;
	}
	
	public int getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(int idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFormaPagamento;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (idFormaPagamento != other.idFormaPagamento)
			return false;
		return true;
	}

}
