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
@Table(name = "produto_complemento")
public class ProdutoComplemento implements Serializable{
    @Id
    @Column(name = "id_produto_complemento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProdutoComplemento;
    
    @ManyToOne()
    @JoinColumn(name = "id_produto", foreignKey = @ForeignKey(name = "pc_produto_fk"))
    private Produto produto;
    
    @ManyToOne()
    @JoinColumn(name = "id_complemento", foreignKey = @ForeignKey(name = "pc_complemento_fk"))
    private Complemento complemento;
    
    @Column(name = "quantidade")
    private Integer quantidade;
    
     @Column(name = "quantidade_limite")
    private Integer quantidadeLimite;
    
    @Column(name = "sequencia")
    private Integer sequencia;
    
    @Column(name = "tipo")//1 - Padrao - 2 - Adicional - 3 -selecao
    private Integer tipo;
    
    @Column(name = "descricaoAgrupamento")
    private String descricaoAgrupamento;

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

    public String getDescricaoAgrupamento() {
        return descricaoAgrupamento;
    }

    public void setDescricaoAgrupamento(String descricaoAgrupamento) {
        this.descricaoAgrupamento = descricaoAgrupamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idProdutoComplemento);
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
        if (!Objects.equals(this.idProdutoComplemento, other.idProdutoComplemento)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
