package marks.gerenciamentopessoa.repository;

import marks.gerenciamentopessoa.model.Credenciais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface credenciaisRepository extends JpaRepository<Credenciais, String> {

}
