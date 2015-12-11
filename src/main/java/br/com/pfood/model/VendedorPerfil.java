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
public class VendedorPerfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_vendor_perfil")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVendorPerfil;

    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pessoa", unique = true, nullable = false, foreignKey = @ForeignKey(name = "vendorPerf_pessoa_fk"))
    private Vendedor vendedor;

    @Column(name = "func_segunda")
    private Boolean funcSegunda = false;

    @Column(name = "segunda_hora_ini")
    private String segHoraIni;

    @Column(name = "segunda_hora_fim")
    private String segHoraFim;

    @Column(name = "func_terca")
    private Boolean funcTerca = false;

    @Column(name = "terca_hora_ini")
    private String tercaHoraIni;

    @Column(name = "terca_hora_fim")
    private String tercaHoraFim;

    @Column(name = "func_quarta")
    private Boolean funcQuarta = false;

    @Column(name = "quarta_hora_ini")
    private String quarHoraIni;

    @Column(name = "quarta_hora_fim")
    private String quarHoraFim;

    @Column(name = "func_quinta")
    private Boolean funcQuinta = false;

    @Column(name = "quinta_hora_ini")
    private String quintaHoraIni;

    @Column(name = "quinta_hora_fim")
    private String quintaHoraFim;

    @Column(name = "func_sexta")
    private Boolean funcSexta = false;

    @Column(name = "sexta_hora_ini")
    private String sextaHoraIni;

    @Column(name = "sexta_hora_fim")
    private String sextaHoraFim;

    @Column(name = "func_sabado")
    private Boolean funcSabado = false;

    @Column(name = "sabado_hora_ini")
    private String sabadoHoraIni;

    @Column(name = "sabado_hora_fim")
    private String sabadoHoraFim;

    @Column(name = "func_domingo")
    private Boolean funcDomingo = false;

    @Column(name = "domingo_hora_ini")
    private String domingoHoraIni;

    @Column(name = "domingo_hora_fim")
    private String domingoHoraFim;

    @Column(name = "func_feriado")
    private Boolean funcFeriado = false;

    @Column(name = "feriado_hora_ini")
    private String feriadoHoraIni;

    @Column(name = "feriado_hora_fim")
    private String feriadoHoraFim;

    
     @Column(name = "fechado")
    private Boolean fechado = true;
    
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
            = @JoinColumn(name = "id_vendor_perfil", foreignKey = @ForeignKey(name = "vendedor_perfil_fp_fk")),
            inverseJoinColumns
            = @JoinColumn(name = "id_forma_pagamento", foreignKey = @ForeignKey(name = "vendedor_perfil_fp_fp_fk")))
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
    
    private Date teste;

    public Date getTeste() {
        return teste;
    }

    public void setTeste(Date teste) {
        this.teste = teste;
    }
    
    

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

    public Boolean getFuncSegunda() {
        return funcSegunda;
    }

    public void setFuncSegunda(Boolean funcSegunda) {
        this.funcSegunda = funcSegunda;
    }

    public String getSegHoraIni() {
        return segHoraIni;
    }

    public void setSegHoraIni(String segHoraIni) {
        this.segHoraIni = segHoraIni;
    }

    public String getSegHoraFim() {
        return segHoraFim;
    }

    public void setSegHoraFim(String segHoraFim) {
        this.segHoraFim = segHoraFim;
    }

    public Boolean getFuncTerca() {
        return funcTerca;
    }

    public void setFuncTerca(Boolean funcTerca) {
        this.funcTerca = funcTerca;
    }

    public String getTercaHoraIni() {
        return tercaHoraIni;
    }

    public void setTercaHoraIni(String tercaHoraIni) {
        this.tercaHoraIni = tercaHoraIni;
    }

    public String getTercaHoraFim() {
        return tercaHoraFim;
    }

    public void setTercaHoraFim(String tercaHoraFim) {
        this.tercaHoraFim = tercaHoraFim;
    }

    public Boolean getFuncQuarta() {
        return funcQuarta;
    }

    public void setFuncQuarta(Boolean funcQuarta) {
        this.funcQuarta = funcQuarta;
    }

    public String getQuarHoraIni() {
        return quarHoraIni;
    }

    public void setQuarHoraIni(String quarHoraIni) {
        this.quarHoraIni = quarHoraIni;
    }

    public String getQuarHoraFim() {
        return quarHoraFim;
    }

    public void setQuarHoraFim(String quarHoraFim) {
        this.quarHoraFim = quarHoraFim;
    }

    public Boolean getFuncQuinta() {
        return funcQuinta;
    }

    public void setFuncQuinta(Boolean funcQuinta) {
        this.funcQuinta = funcQuinta;
    }

    public String getQuintaHoraIni() {
        return quintaHoraIni;
    }

    public void setQuintaHoraIni(String quintaHoraIni) {
        this.quintaHoraIni = quintaHoraIni;
    }

    public String getQuintaHoraFim() {
        return quintaHoraFim;
    }

    public void setQuintaHoraFim(String quintaHoraFim) {
        this.quintaHoraFim = quintaHoraFim;
    }

    public Boolean getFuncSexta() {
        return funcSexta;
    }

    public void setFuncSexta(Boolean funcSexta) {
        this.funcSexta = funcSexta;
    }

    public String getSextaHoraIni() {
        return sextaHoraIni;
    }

    public void setSextaHoraIni(String sextaHoraIni) {
        this.sextaHoraIni = sextaHoraIni;
    }

    public String getSextaHoraFim() {
        return sextaHoraFim;
    }

    public void setSextaHoraFim(String sextaHoraFim) {
        this.sextaHoraFim = sextaHoraFim;
    }

    public Boolean getFuncSabado() {
        return funcSabado;
    }

    public void setFuncSabado(Boolean funcSabado) {
        this.funcSabado = funcSabado;
    }

    public String getSabadoHoraIni() {
        return sabadoHoraIni;
    }

    public void setSabadoHoraIni(String sabadoHoraIni) {
        this.sabadoHoraIni = sabadoHoraIni;
    }

    public String getSabadoHoraFim() {
        return sabadoHoraFim;
    }

    public void setSabadoHoraFim(String sabadoHoraFim) {
        this.sabadoHoraFim = sabadoHoraFim;
    }

    public Boolean getFuncDomingo() {
        return funcDomingo;
    }

    public void setFuncDomingo(Boolean funcDomingo) {
        this.funcDomingo = funcDomingo;
    }

    public String getDomingoHoraIni() {
        return domingoHoraIni;
    }

    public void setDomingoHoraIni(String domingoHoraIni) {
        this.domingoHoraIni = domingoHoraIni;
    }

    public String getDomingoHoraFim() {
        return domingoHoraFim;
    }

    public void setDomingoHoraFim(String domingoHoraFim) {
        this.domingoHoraFim = domingoHoraFim;
    }

    public Boolean getFuncFeriado() {
        return funcFeriado;
    }

    public void setFuncFeriado(Boolean funcFeriado) {
        this.funcFeriado = funcFeriado;
    }

    public String getFeriadoHoraIni() {
        return feriadoHoraIni;
    }

    public void setFeriadoHoraIni(String feriadoHoraIni) {
        this.feriadoHoraIni = feriadoHoraIni;
    }

    public String getFeriadoHoraFim() {
        return feriadoHoraFim;
    }

    public void setFeriadoHoraFim(String feriadoHoraFim) {
        this.feriadoHoraFim = feriadoHoraFim;
    }

    public Boolean getFechado() {
        return fechado;
    }

    public void setFechado(Boolean fechado) {
        this.fechado = fechado;
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
        final VendedorPerfil other = (VendedorPerfil) obj;
        if (this.idVendorPerfil != other.idVendorPerfil) {
            return false;
        }
        return true;
    }

}
