package br.com.pfood.model;


import br.com.pfood.enumerated.VendedorSituacaoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Columns;



@Entity
@Table(name="vendedor" )
public class Vendedor implements Serializable , Comparable<Vendedor> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_vendedor")
	private Integer idVendedor;

	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_pessoa", unique = true , nullable = false , foreignKey = @ForeignKey(name = "vendedor_pessoa_fk"))
	private Pessoa pessoa = new Pessoa();

	@Enumerated(EnumType.STRING)
	@Column(name="situacao")
	private VendedorSituacaoEnum situacao;

        @Column(name = "tags")
        private String tags;
	
        @Column(name = "telefone1")
        private String telefone1;
        
        
        @Column(name = "telefone2")
        private String telefone2;
        
        
        @Column(name = "telefone3")
        private String telefone3;
        
        
        @Column(name = "telefone4")
        private String telefone4;
        
        
        @Column(name = "telefone5")
        private String telefone5;
        
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_alteracao")
	private Date dataAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name  = "data_inclusao")
	private Date dataInclusao;

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

    public VendedorSituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(VendedorSituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public String getTelefone4() {
        return telefone4;
    }

    public void setTelefone4(String telefone4) {
        this.telefone4 = telefone4;
    }

    public String getTelefone5() {
        return telefone5;
    }

    public void setTelefone5(String telefone5) {
        this.telefone5 = telefone5;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idVendedor);
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
        final Vendedor other = (Vendedor) obj;
        if (!Objects.equals(this.idVendedor, other.idVendedor)) {
            return false;
        }
        return true;
    }
	




	@Override
	public int compareTo(Vendedor o) {
		return this.pessoa.getRazaoSocial().compareTo( o.getPessoa().getRazaoSocial());
	}


	
}
