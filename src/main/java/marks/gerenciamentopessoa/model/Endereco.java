package marks.gerenciamentopessoa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Informe um número!")
    private String numero;

    @NotNull
    @Size(min = 3, message = "O logradouro precisa ter no minimo 3 caracteres!")
    private String logradouro;

    private String complemento;

    @NotNull(message = "Informe um tipo de endereço!")
    @OneToOne
    @JoinColumn(name = "id_tipo_endereco")
    private TipoEndereco tipoEndereco;
    
    @Valid
    @NotNull(message = "Informe um CEP!")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cep")
    private CEP cep;

    
}
