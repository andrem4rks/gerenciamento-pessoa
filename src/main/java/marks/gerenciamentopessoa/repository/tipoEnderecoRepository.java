package marks.gerenciamentopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import marks.gerenciamentopessoa.model.TipoEndereco;

public interface tipoEnderecoRepository extends JpaRepository<TipoEndereco, Long> {
    
}
