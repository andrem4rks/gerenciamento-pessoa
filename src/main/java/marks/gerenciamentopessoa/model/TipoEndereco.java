package marks.gerenciamentopessoa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoEndereco extends Campos {

  @OneToMany(mappedBy = "tipoEndereco", orphanRemoval = false)
  private List<Endereco> endereco;

}
