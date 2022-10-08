package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.Endereco;

public interface enderecoRepository extends JpaRepository<Endereco, Long> {
  
}
