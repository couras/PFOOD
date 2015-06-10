package br.com.pfood.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private int idProduto;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @Column(name = "tag", length = 2000, nullable = false)
    private String tag;
    
    @Column(name = "valor_padrao", columnDefinition = "numeric(12,4) default 0")
    private Double valorPadrao;

    @Column(name = "descriComplementoPadrao")
    private String descriComplementoPadrao;
    
    @ManyToMany()
    @JoinTable(name = "produto_complemento_padrao", joinColumns
            = @JoinColumn(name = "id_produto"),
            inverseJoinColumns
            = @JoinColumn(name = "id_complemento"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @BatchSize(size = 15)
    private List<Complemento> listaComplementoPadrao = new ArrayList<Complemento>();

        @Column(name = "descriComplementoAdicional")
    private String descriComplementoAdicional;
    
    @ManyToMany()
    @JoinTable(name = "produto_complemento_adicional", joinColumns
            = @JoinColumn(name = "id_produto"),
            inverseJoinColumns
            = @JoinColumn(name = "id_complemento"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @BatchSize(size = 15)
    private List<Complemento> listaComplementoAdcional = new ArrayList<Complemento>();

    
    @Column(name = "descriComplementoEscolha")
    private String descriComplementoEscaolha;
    
    @ManyToMany()
    @JoinTable(name = "produto_complemento_escolha", joinColumns
            = @JoinColumn(name = "id_produto"),
            inverseJoinColumns
            = @JoinColumn(name = "id_complemento"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @BatchSize(size = 15)
    private List<Complemento> listaComplementoEscolha = new ArrayList<Complemento>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(Double valorPadrao) {
        this.valorPadrao = valorPadrao;
    }

    public List<Complemento> getListaComplementoPadrao() {
        return listaComplementoPadrao;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setListaComplementoPadrao(List<Complemento> listaComplementoPadrao) {
        this.listaComplementoPadrao = listaComplementoPadrao;
    }

    public List<Complemento> getListaComplementoAdcional() {
        return listaComplementoAdcional;
    }

    public void setListaComplementoAdcional(List<Complemento> listaComplementoAdcional) {
        this.listaComplementoAdcional = listaComplementoAdcional;
    }

    public List<Complemento> getListaComplementoEscolha() {
        return listaComplementoEscolha;
    }

    public void setListaComplementoEscolha(List<Complemento> listaComplementoEscolha) {
        this.listaComplementoEscolha = listaComplementoEscolha;
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

    public String getDescriComplementoPadrao() {
        return descriComplementoPadrao;
    }

    public void setDescriComplementoPadrao(String descriComplementoPadrao) {
        this.descriComplementoPadrao = descriComplementoPadrao;
    }

    public String getDescriComplementoAdicional() {
        return descriComplementoAdicional;
    }

    public void setDescriComplementoAdicional(String descriComplementoAdicional) {
        this.descriComplementoAdicional = descriComplementoAdicional;
    }

    public String getDescriComplementoEscaolha() {
        return descriComplementoEscaolha;
    }

    public void setDescriComplementoEscaolha(String descriComplementoEscaolha) {
        this.descriComplementoEscaolha = descriComplementoEscaolha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idProduto;
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
        final Produto other = (Produto) obj;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }


}
