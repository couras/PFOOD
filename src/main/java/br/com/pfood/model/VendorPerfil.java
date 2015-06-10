package br.com.pfood.model;

import br.com.pfood.enumerated.VendedorSituacaoEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@Entity
@Table(name = "vendor_perfil")
public class VendorPerfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_vendor_perfil")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVendorPerfil;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pessoa", unique = true, nullable = false, foreignKey = @ForeignKey(name = "vendorPerf_pessoa_fk"))
    private Vendedor vendedor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_ini1")
    private Date funcIni1;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_ini2")
    private Date funcIni2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_ini3")
    private Date funcIni3;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_ini4")
    private Date funcIni4;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_fim1")
    private Date funcFim1;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_fim2")
    private Date funcFim2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_fim3")
    private Date funcFim3;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "func_fim4")
    private Date funcFim4;

    @ManyToMany()
    @JoinTable(name = "vendor_perfil_cidade_entrega", joinColumns
            = @JoinColumn(name = "id_vendor_perfil"),
            inverseJoinColumns
            = @JoinColumn(name = "id_cidade"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @BatchSize(size = 15)
    private List<Cidade> listaCidades = new ArrayList<Cidade>();

    @ManyToMany()
    @JoinTable(name = "vendor_perfil_forma_pagamento", joinColumns
            = @JoinColumn(name = "id_vendor_perfil" , foreignKey = @ForeignKey(name = "vendedor_perfil_fp_fk")),
            inverseJoinColumns
            = @JoinColumn(name = "id_forma_pagamento" , foreignKey = @ForeignKey(name = "vendedor_perfil_fp_fp_fk")))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @BatchSize(size = 15)
    private List<FormaPagamento> listaFormaPagamentos = new ArrayList<FormaPagamento>();

    @Column(name = "valor_entrega_default", columnDefinition = "numeric(6,2) default 0")
    private Double valorEntregaDefault;

    @Column(name = "n_cobra_entrega_apartir_valor", columnDefinition = "numeric(6,2) default 0")
    private Double nCobraEntregaApValor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public int getIdVendorPerfil() {
        return idVendorPerfil;
    }

    public void setIdVendorPerfil(int idVendorPerfil) {
        this.idVendorPerfil = idVendorPerfil;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFuncIni1() {
        return funcIni1;
    }

    public void setFuncIni1(Date funcIni1) {
        this.funcIni1 = funcIni1;
    }

    public Date getFuncIni2() {
        return funcIni2;
    }

    public void setFuncIni2(Date funcIni2) {
        this.funcIni2 = funcIni2;
    }

    public Date getFuncIni3() {
        return funcIni3;
    }

    public void setFuncIni3(Date funcIni3) {
        this.funcIni3 = funcIni3;
    }

    public Date getFuncIni4() {
        return funcIni4;
    }

    public void setFuncIni4(Date funcIni4) {
        this.funcIni4 = funcIni4;
    }

    public Date getFuncFim1() {
        return funcFim1;
    }

    public void setFuncFim1(Date funcFim1) {
        this.funcFim1 = funcFim1;
    }

    public Date getFuncFim2() {
        return funcFim2;
    }

    public void setFuncFim2(Date funcFim2) {
        this.funcFim2 = funcFim2;
    }

    public Date getFuncFim3() {
        return funcFim3;
    }

    public void setFuncFim3(Date funcFim3) {
        this.funcFim3 = funcFim3;
    }

    public Date getFuncFim4() {
        return funcFim4;
    }

    public void setFuncFim4(Date funcFim4) {
        this.funcFim4 = funcFim4;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<FormaPagamento> getListaFormaPagamentos() {
        return listaFormaPagamentos;
    }

    public void setListaFormaPagamentos(List<FormaPagamento> listaFormaPagamentos) {
        this.listaFormaPagamentos = listaFormaPagamentos;
    }

    public Double getValorEntregaDefault() {
        return valorEntregaDefault;
    }

    public void setValorEntregaDefault(Double valorEntregaDefault) {
        this.valorEntregaDefault = valorEntregaDefault;
    }

    public Double getnCobraEntregaApValor() {
        return nCobraEntregaApValor;
    }

    public void setnCobraEntregaApValor(Double nCobraEntregaApValor) {
        this.nCobraEntregaApValor = nCobraEntregaApValor;
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
        hash = 41 * hash + this.idVendorPerfil;
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
        final VendorPerfil other = (VendorPerfil) obj;
        if (this.idVendorPerfil != other.idVendorPerfil) {
            return false;
        }
        return true;
    }

}
