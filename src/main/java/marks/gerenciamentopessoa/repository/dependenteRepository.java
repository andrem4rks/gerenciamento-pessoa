package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Dependente;

public interface dependenteRepository extends JpaRepository<Dependente, Long> {
    
}
