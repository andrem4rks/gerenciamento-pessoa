package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Instrucao;

public interface instrucaoRepository extends JpaRepository<Instrucao, Long> {
  
}
