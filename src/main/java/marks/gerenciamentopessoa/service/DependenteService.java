package marks.gerenciamentopessoa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.repository.dependenteRepository;

@Service
public class DependenteService {
  @Autowired
  private dependenteRepository dependenteRepository;

  public Dependente save(Dependente dependente) {
    return dependenteRepository.save(dependente);
  }

  public Optional<Dependente> findById(Long id) {
    return dependenteRepository.findById(id);
  }

  public void remove(Long id) {
    dependenteRepository.deleteById(id);
  }
}
