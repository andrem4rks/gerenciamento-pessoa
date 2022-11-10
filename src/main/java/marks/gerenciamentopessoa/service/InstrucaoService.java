package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Instrucao;
import marks.gerenciamentopessoa.repository.instrucaoRepository;

@Service
public class InstrucaoService {
  @Autowired
  private instrucaoRepository instrucaoRepository;

  public List<Instrucao> findAll() {
    return instrucaoRepository.findAll();
  }
}
