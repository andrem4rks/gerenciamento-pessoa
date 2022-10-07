package marks.gerenciamentopessoa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa extends PessoaPrincipal {
    
    @NotNull
    private String nomeSocial;

    @OneToMany
    private List<Dependente> dependente;

    @OneToOne
    @JoinColumn(name = "id_sexo")
    private Sexo sexo;

    @OneToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;

    public Raca getRaca() {
      return raca;
    }

    public void setRaca(Raca raca) {
      this.raca = raca;
    }

    public Sexo getSexo() {
      return sexo;
    }

    public void setSexo(Sexo sexo) {
      this.sexo = sexo;
    }

    public List<Dependente> getDependente() {
        return dependente;
    }

    public void setDependente(List<Dependente> dependente) {
        this.dependente = dependente;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

}
