package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.TipoDependente;

public interface tipoDependenteRepository extends JpaRepository <TipoDependente, Long> {

}
