package marks.gerenciamentopessoa.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TipoEndereco extends Campos {

  @OneToMany(mappedBy = "tipoEndereco")
  private List<Endereco> endereco;

}
