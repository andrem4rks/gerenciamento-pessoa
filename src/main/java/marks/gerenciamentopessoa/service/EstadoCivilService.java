package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.EstadoCivil;
import marks.gerenciamentopessoa.repository.estadoCivilRepository;

@Service
public class EstadoCivilService {
  @Autowired
  private estadoCivilRepository estadoCivilRepository;

  public List<EstadoCivil> findAll() {
    return estadoCivilRepository.findAll();
  }
}
