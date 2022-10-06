package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Pessoa;

public interface pessoaRepository extends JpaRepository <Pessoa, Long> {
  
}
