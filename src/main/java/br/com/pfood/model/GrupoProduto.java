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
@Table(name = "grupo_produto")
public class GrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_produto")
    private int idGrupoProduto;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "id_vendedor" , foreignKey = @ForeignKey(name = "gp_vendor_fk"))
    private Vendedor vendedor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(int idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idGrupoProduto;
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
        final GrupoProduto other = (GrupoProduto) obj;
        if (this.idGrupoProduto != other.idGrupoProduto) {
            return false;
        }
        return true;
    }

}
