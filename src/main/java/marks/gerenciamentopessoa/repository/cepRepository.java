package marks.gerenciamentopessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.CEP;

public interface cepRepository extends JpaRepository<CEP, Long>{
  List<CEP> findAllByNumeroCep(String cep);
}
