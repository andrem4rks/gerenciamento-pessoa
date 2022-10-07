package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Pais;

public interface paisRepository extends JpaRepository<Pais, Long> {
    
}
