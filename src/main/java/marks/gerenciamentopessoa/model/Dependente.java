package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Dependente extends PessoaPrincipal {
    
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}
