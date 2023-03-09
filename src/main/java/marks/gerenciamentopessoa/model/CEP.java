package marks.gerenciamentopessoa.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CEP {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "Informe um CEP!")
  private String numeroCep;

  @NotEmpty(message = "Informe um estado!")
  private String estado;

  @NotEmpty(message = "Informe um município!")
  private String municipio;

  private String bairro;

  @OneToMany(mappedBy = "cep")
  private List<Endereco> endereco;

}
