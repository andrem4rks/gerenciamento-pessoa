package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Sexo;

public interface sexoRepository extends JpaRepository<Sexo, Long>{
  
}
