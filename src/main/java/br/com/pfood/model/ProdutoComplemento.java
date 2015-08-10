/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.model;

import br.com.pfood.enumerated.ProdutoComplementoTipoEnum;
import java.io.Serializable;
import java.util.Objects;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author palazzio
 */
@Entity
@Table(name = "produto_complemento" 
, uniqueConstraints = @UniqueConstraint(columnNames = {"id_produto" , "id_complemento", "tipo" , "id_tipo_agrupamento_complemento" }))
public class ProdutoComplemento implements Serializable{
    
    @Id
    @Column(name = "id_produto_complemento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProdutoComplemento =0;
    
    @ManyToOne()
    @JoinColumn(name = "id_produto", nullable = false ,foreignKey = @ForeignKey(name = "pc_produto_fk"))
    private Produto produto;
    
    @ManyToOne()
    @JoinColumn(name = "id_complemento", nullable = false,  foreignKey = @ForeignKey(name = "pc_complemento_fk"))
    private Complemento complemento = new Complemento();
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade =1 ;
    
    @Column(name = "quantidade_limite" , nullable = false )
    private Integer quantidadeLimite =0;
    
    @Column(name = "sequencia" , nullable = false )
    private Integer sequencia =0;
    
    @Column(name = "tipo" , nullable = false)//1 - Padrao - 2 - Adicional - 3 -selecao
    private Integer tipo;
    
    @ManyToOne()
    @JoinColumn(name = "id_tipo_agrupamento_complemento")
    private TipoAgrupamentoComplemento tipoAgrupamentoComplemento;
    
    public Integer getIdProdutoComplemento() {
        return idProdutoComplemento;
    }

    public void setIdProdutoComplemento(Integer idProdutoComplemento) {
        this.idProdutoComplemento = idProdutoComplemento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidadeLimite() {
        return quantidadeLimite;
    }

    public void setQuantidadeLimite(Integer quantidadeLimite) {
        this.quantidadeLimite = quantidadeLimite;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public TipoAgrupamentoComplemento getTipoAgrupamentoComplemento() {
        return tipoAgrupamentoComplemento;
    }

    public void setTipoAgrupamentoComplemento(TipoAgrupamentoComplemento tipoAgrupamentoComplemento) {
        this.tipoAgrupamentoComplemento = tipoAgrupamentoComplemento;
    }

 

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.produto);
        hash = 61 * hash + Objects.hashCode(this.complemento);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.tipoAgrupamentoComplemento);
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
        final ProdutoComplemento other = (ProdutoComplemento) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.tipoAgrupamentoComplemento, other.tipoAgrupamentoComplemento)) {
            return false;
        }
        return true;
    }


    

    


    
    
    
    
    
}
