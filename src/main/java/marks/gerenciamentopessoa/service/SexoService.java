package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Sexo;
import marks.gerenciamentopessoa.repository.sexoRepository;

@Service
public class SexoService {

  @Autowired
  private sexoRepository sexoRepository;

  public List<Sexo> findAll() {
    return sexoRepository.findAll();
  } 
}
