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
@Table(name = "imagem_produto")
public class ImagemProduto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_imagem_produto")
    private int idImagemProduto;

    @ManyToOne
    @JoinColumn(name="id_produto" , foreignKey = @ForeignKey(name = "imgProd_prod_fk"))
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="id_imagem" , foreignKey = @ForeignKey(name = "imgProd_img_fk"))
    private  Imagem imagem ;
       
    @Column(name = "sequencia")
    private Integer sequencia=0;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdImagemProduto() {
        return idImagemProduto;
    }

    public void setIdImagemProduto(int idImagemProduto) {
        this.idImagemProduto = idImagemProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
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
        hash = 37 * hash + this.idImagemProduto;
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
        final ImagemProduto other = (ImagemProduto) obj;
        if (this.idImagemProduto != other.idImagemProduto) {
            return false;
        }
        return true;
    }
    
    
}
