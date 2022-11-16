package marks.gerenciamentopessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.TipoDependente;
import marks.gerenciamentopessoa.repository.tipoDependenteRepository;

@Service
public class TipoDependenteService {
  @Autowired
  private tipoDependenteRepository tipoDependenteRepository;

  public List<TipoDependente> findAll() {
    return tipoDependenteRepository.findAll();
  }
}
