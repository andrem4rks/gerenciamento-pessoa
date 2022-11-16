package marks.gerenciamentopessoa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.repository.dependenteRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;

@Service
public class DependenteService {
  @Autowired
  private dependenteRepository dependenteRepository;

  @Autowired
  private pessoaRepository pessoaRepository;

  public Boolean save(Dependente dependente, Long id_pessoa) {
    if(testeCpfExiste(dependente)) {
      dependente.setPessoa(pessoaRepository.findById(id_pessoa).get());
      dependenteRepository.save(dependente);
      return true;
    }
    return false;
  }

  public Optional<Dependente> findById(Long id) {
    return dependenteRepository.findById(id);
  }

  public Boolean atualiza(Dependente dependente, Long id_sessao, Long id_representante) {
    if(testeCpfSessao(id_sessao, dependente) || testeCpfExiste(dependente)) {
      dependente.setPessoa(pessoaRepository.findById(id_representante).get());
      dependenteRepository.save(dependente);
      return true;
    }
    return false;
  }

  public void remove(Long id) {
    dependenteRepository.deleteById(id);
  }

  //Funcoes de teste
  public Boolean testeCpfExiste(Dependente dependente) {
    if(pessoaRepository.findByCpf(dependente.getCpf()) == null && dependenteRepository.findByCpf(dependente.getCpf()) == null) {
      return true;
    }
    return false;
  }

  public Boolean testeCpfSessao(Long id_sessao, Dependente dependente) {
    if(dependenteRepository.findById(id_sessao).get().getCpf().equals(dependente.getCpf())) {
      return true;
    } 
    return false;
  }
}
