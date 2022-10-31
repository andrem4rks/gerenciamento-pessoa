package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Deficiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean deficienciaFisica;
    
    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean deficienciaVisual;

    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean deficienciaAuditiva;

    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean deficienciaMental;

    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean deficienciaIntelectual;

    @NotNull(message = "Selecione pelo menos uma opção")
    private boolean reabilitado;

    private boolean cota;

    private String observacao;


}
