package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Raca;
import marks.gerenciamentopessoa.repository.racaRepository;

@Service
public class RacaService {

  @Autowired
  private racaRepository racaRepository;

  public List<Raca> findAll() {
    return racaRepository.findAll();
  } 
}
