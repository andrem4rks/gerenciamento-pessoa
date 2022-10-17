package marks.gerenciamentopessoa.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroPessoa {
    
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull
    @Size(min=3, message = "O nome deve ter no mínimo 3 caracteres!")
    private String nome;

    @NotNull(message = "Insira o sexo!")
    private Long sexo;

    @NotNull(message = "Insira a raça!")
    private Long raca;

    @NotNull(message = "Insira o estado civil!")
    private Long estado_civil;

    private String nome_social;

    private String data_nascimento;

    @NotNull(message = "Insira o pais de nascimento!")
    private Long pais_nascimento;

    @NotNull(message = "Insira o pais de nacionalidade!")
    private Long pais_nacionalidade;

    private Boolean local_residencia;

    @NotNull
    @Size(min=3, message = "Insira um CEP válido!")
    private String cep;

    @NotNull(message = "Insira o estado!")
    private Long estado;

    @NotNull(message = "Insira o município!")
    private Long municipio;

    @Size(min = 3, message = "Insira um bairro válido!")
    private String Bairro;

    @NotNull(message = "Insira um tipo de logradouro válido!")
    private String logradouro;

    @NotNull(message = "Insira um número válido para a residência!")
    private String numero;

    private String complemento;
}
