package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String logradouro;

    private String complemento;

    @OneToOne
    @JoinColumn(name = "id_tipo_endereco")
    private TipoEndereco tipoEndereco;

    @OneToOne
    @JoinColumn(name = "id_cep")
    private CEP cep;

    public Endereco(Long id, @NotNull @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres") String numero,
        @NotNull @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres") String logradouro,
        String complemento, TipoEndereco tipoEndereco, CEP cep) {
      this.id = id;
      this.numero = numero;
      this.logradouro = logradouro;
      this.complemento = complemento;
      this.tipoEndereco = tipoEndereco;
      this.cep = cep;
    }

    public Endereco() {
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNumero() {
      return numero;
    }

    public void setNumero(String numero) {
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

    public TipoEndereco getTipoEndereco() {
      return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
      this.tipoEndereco = tipoEndereco;
    }

    public CEP getCep() {
      return cep;
    }

    public void setCep(CEP cep) {
      this.cep = cep;
    }



    
}
