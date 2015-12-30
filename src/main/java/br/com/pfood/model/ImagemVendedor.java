/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author palazzio
 */
@Entity
@Table(name = "imagem_vendedor")
public class ImagemVendedor implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem_vendedor")
    private int idImagemVendedor;

    @ManyToOne
    @JoinColumn(name="id_vendedor" , foreignKey = @ForeignKey(name = "imgProd_vendor_fk"))
    private Vendedor vendedor;
       
    @Column(name = "sequencia")
    private Integer sequencia=0;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdImagemVendedor() {
        return idImagemVendedor;
    }

    public void setIdImagemVendedor(int idImagemVendedor) {
        this.idImagemVendedor = idImagemVendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
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
        hash = 37 * hash + this.idImagemVendedor;
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
        final ImagemVendedor other = (ImagemVendedor) obj;
        if (this.idImagemVendedor != other.idImagemVendedor) {
            return false;
        }
        return true;
    }
    
    
}
