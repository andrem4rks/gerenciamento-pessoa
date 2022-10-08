package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CEP {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String numero_cep;

  @NotNull
  private String estado;

  @NotNull
  private String municipio;

  @NotNull
  private String bairro;

  @OneToOne
  @JoinColumn(name = "id_tipo_endereco")
  private TipoEndereco tipoEndereco;


 

  public CEP() {
  }

  public CEP(Long id, @NotNull String numero_cep, @NotNull String estado, @NotNull String municipio,
      @NotNull String bairro) {
    this.id = id;
    this.numero_cep = numero_cep;
    this.estado = estado;
    this.municipio = municipio;
    this.bairro = bairro;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumero_cep() {
    return numero_cep;
  }

  public void setNumero_cep(String numero_cep) {
    this.numero_cep = numero_cep;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getMunicipio() {
    return municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public TipoEndereco getTipoEndereco() {
    return tipoEndereco;
  }

  public void setTipoEndereco(TipoEndereco tipoEndereco) {
    this.tipoEndereco = tipoEndereco;
  }
}
