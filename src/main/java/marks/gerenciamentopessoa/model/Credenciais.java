package marks.gerenciamentopessoa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Credenciais {
  @Id
  private String userName;
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  private Pessoa pessoa;
}
