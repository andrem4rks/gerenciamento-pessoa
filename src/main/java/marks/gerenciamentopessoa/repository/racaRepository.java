package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Raca;

public interface racaRepository extends JpaRepository<Raca, Long>{
  
}
