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
    private String rua;

    private String complemento;

    @OneToOne
    @JoinColumn(name = "id_cep")
    private CEP cep;

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

    public String getRua() {
      return rua;
    }

    public void setRua(String rua) {
      this.rua = rua;
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

    public Endereco(Long id, @NotNull Integer numero, @NotNull String rua, String complemento, CEP cep) {
      this.id = id;
      this.numero = numero;
      this.rua = rua;
      this.complemento = complemento;
      this.cep = cep;
    }

    public Endereco() {
    }

    
}
