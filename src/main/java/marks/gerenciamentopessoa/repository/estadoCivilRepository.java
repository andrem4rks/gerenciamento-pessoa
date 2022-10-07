package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.EstadoCivil;

public interface estadoCivilRepository extends JpaRepository <EstadoCivil, Long> {
    
}
