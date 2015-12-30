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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "complemento")
public class Complemento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_complemento")
    private int idComplemento;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @Column(name = "valor_adiciona", columnDefinition = "numeric(6,2) default 0")
    private Double valorAdiciona =0.0;

    @Column(name = "valor_remover", columnDefinition = "numeric(6,2) default 0")
    private Double valorRemover =0.0;

    @ManyToOne()
    @JoinColumn(name = "id_vendedor" , foreignKey = @ForeignKey(name = "comp_vendor_fk"))
    private Vendedor vendedor;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdComplemento() {
        return idComplemento;
    }

    public void setIdComplemento(int idComplemento) {
        this.idComplemento = idComplemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorAdiciona() {
        return valorAdiciona;
    }

    public void setValorAdiciona(Double valorAdiciona) {
        this.valorAdiciona = valorAdiciona;
    }

    public Double getValorRemover() {
        return valorRemover;
    }

    public void setValorRemover(Double valorRemover) {
        this.valorRemover = valorRemover;
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
        hash = 71 * hash + this.idComplemento;
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
        final Complemento other = (Complemento) obj;
        if (this.idComplemento != other.idComplemento) {
            return false;
        }
        return true;
    }

  
}
