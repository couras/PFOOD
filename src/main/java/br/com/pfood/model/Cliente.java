package br.com.pfood.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import javax.persistence.ForeignKey;


@Entity
@Table(name="cliente")

public class Cliente implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cliente")
	private Integer idCliente;

	
	@OneToOne(optional = false)
	@Cascade( value= org.hibernate.annotations.CascadeType.MERGE)
	@JoinColumn(name="id_pessoa", unique = true , foreignKey = @ForeignKey(name="cliente_pessoa_fk"))
	private Pessoa pessoa = new Pessoa();
		

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_inclusao")
	private Date dataInclusao;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }



    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idCliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }
	
	
	

}
