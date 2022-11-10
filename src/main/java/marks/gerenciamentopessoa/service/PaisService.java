package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Pais;
import marks.gerenciamentopessoa.repository.paisRepository;

@Service
public class PaisService {
  @Autowired
  private paisRepository paisRepository;

  public List<Pais> findAll() {
    return paisRepository.findAll();
  }

}
