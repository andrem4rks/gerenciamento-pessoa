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

    @NotNull
    private Integer numero;

    @NotNull
    private String logradouro;

    private String complemento;

    @OneToOne
    @JoinColumn(name = "id_tipo_endereco")
    private TipoEndereco tipoEndereco;

   

    @OneToOne
    @JoinColumn(name = "id_cep")
    private CEP cep;

    public TipoEndereco getTipoEndereco() {
      return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
      this.tipoEndereco = tipoEndereco;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Integer getNumero() {
      return numero;
    }

    public void setNumero(Integer numero) {
      this.numero = numero;
    }

    public String getLogradouro() {
      return logradouro;
    }

    public void setLogradouro(String logradouro) {
      this.logradouro = logradouro;
    }

    public String getComplemento() {
      return complemento;
    }

    public void setComplemento(String complemento) {
      this.complemento = complemento;
    }

    public CEP getCep() {
      return cep;
    }

    public void setCep(CEP cep) {
      this.cep = cep;
    }

    public Endereco(Long id, @NotNull Integer numero, @NotNull String logradouro, String complemento, CEP cep) {
      this.id = id;
      this.numero = numero;
      this.logradouro = logradouro;
      this.complemento = complemento;
      this.cep = cep;
    }

    public Endereco() {
    }

    
}
