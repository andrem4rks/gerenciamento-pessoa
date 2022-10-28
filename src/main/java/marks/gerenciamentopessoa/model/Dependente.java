package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dependente extends PessoaPrincipal {

    @NotNull(message = "Selecione pelo menos uma opção")
    @OneToOne
    @JoinColumn(name = "id_tipo_dependente")
    private TipoDependente tipoDependente;

    @OneToOne
    @JoinColumn(name = "id_deficiencia")
    private Deficiencia deficiencias;
}
