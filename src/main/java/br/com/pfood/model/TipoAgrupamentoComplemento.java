/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author palazzio
 */
@Entity
@Table(name = "tipo_agrupamento_complemento")
public class TipoAgrupamentoComplemento  implements Serializable{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id_tipo_agrupamento_complemento")
    private Integer idTipoAgrupamentoComplemento  =  0 ;
    
    @Column(name = "descricao")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="id_vendedor" , foreignKey = @ForeignKey(name = "tp_comp_vendor_fk"))
    private Vendedor vendedor;

    public Integer getIdTipoAgrupamentoComplemento() {
        return idTipoAgrupamentoComplemento;
    }

    public void setIdTipoAgrupamentoComplemento(Integer idTipoAgrupamentoComplemento) {
        this.idTipoAgrupamentoComplemento = idTipoAgrupamentoComplemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash = 19 * hash + Objects.hashCode(this.idTipoAgrupamentoComplemento);
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
        final TipoAgrupamentoComplemento other = (TipoAgrupamentoComplemento) obj;
        if (!Objects.equals(this.idTipoAgrupamentoComplemento, other.idTipoAgrupamentoComplemento)) {
            return false;
        }
        return true;
    }

  
  

    
}

