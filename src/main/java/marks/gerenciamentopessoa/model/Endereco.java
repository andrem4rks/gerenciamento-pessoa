package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean localResidencia;

    @NotNull
    private String cep;

    @OneToOne
    @JoinColumn(name = "id_tipoEndereco")
    private TipoEndereco tipoEndereco;

    @NotNull
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    private String bairro;

    @NotNull
    private String uf;

    @NotNull
    private String municipio;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isLocalResidencia() {
        return this.localResidencia;
    }

    public Boolean getLocalResidencia() {
        return this.localResidencia;
    }

    public void setLocalResidencia(Boolean localResidencia) {
        this.localResidencia = localResidencia;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoEndereco getTipoEndereco() {
        return this.tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}
