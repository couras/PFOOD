package br.com.pfood.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome_fantasia", length = 100)
    private String nomeFantasia;

    @Column(name = "razao_social", length = 100 ,nullable = false)
    private String razaoSocial;

    @Column(name = "endereco", length = 200, nullable = false)
    private String endereco;

    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_cidade", foreignKey = @ForeignKey(name = "pessoa_cidade"), nullable = false)
    private Cidade cidade = new Cidade();

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "cpf_cnpj", length = 18, unique = true)
    private String cpfCnpj;

    @Column(name = "rg_ie", length = 20)
    private String rgIe;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "latitude", length = 100)
    private String latitude;

    @Column(name = "longitude", length = 100)
    private String longitude;

    @Column(name = "pesquisa_endereco", columnDefinition = "bit(1) default true")
    private Boolean pesquisaEndereco = true;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Date dataCadastro = new Date();

    @Column(name = "endereco_numero", length = 11)
    private String enderecoNumero;

    @Column(name = "endereco_complemento", length = 30)
    private String enderecoComplemento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }





    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Boolean getPesquisaEndereco() {
        return pesquisaEndereco;
    }

    public void setPesquisaEndereco(Boolean pesquisaEndereco) {
        this.pesquisaEndereco = pesquisaEndereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
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
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idPessoa);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }

    
    
    
}
