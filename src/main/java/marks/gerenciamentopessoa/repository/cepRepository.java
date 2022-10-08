package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.CEP;

public interface cepRepository extends JpaRepository<CEP, Long>{
  CEP findByCep(String cep);
}
