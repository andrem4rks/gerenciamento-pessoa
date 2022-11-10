package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.TipoEndereco;
import marks.gerenciamentopessoa.repository.tipoEnderecoRepository;

@Service
public class TipoEnderecoService {
  @Autowired
  private tipoEnderecoRepository tipoEnderecoRepository;

  public List<TipoEndereco> findAll() {
    return tipoEnderecoRepository.findAll();
  }
}
