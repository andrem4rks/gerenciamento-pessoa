package marks.gerenciamentopessoa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
public class Pessoa extends PessoaPrincipal {
    

    private String nomeSocial;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Dependente> dependentes;

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_pais_nascimento")
    private Pais paisNascimento;

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_pais_nacionalidade")
    private Pais paisNacionalidade;

    @Valid
    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_instrucao")
    private Instrucao instrucao;
}
