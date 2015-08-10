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
@Table(name = "imagem")
public class Imagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_imagem")
    private int idImagem;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "nome_arquivo",  nullable = false)
    private String nomeArquivo;
    
    @Column(name = "hash")
    private String hash;
    
    @Column(name = "sequencia")
    private Integer sequencia =0;
    
    @Column(name = "codigo")
    private Integer codigo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idImagem;
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
        final Imagem other = (Imagem) obj;
        if (this.idImagem != other.idImagem) {
            return false;
        }
        return true;
    }


}
