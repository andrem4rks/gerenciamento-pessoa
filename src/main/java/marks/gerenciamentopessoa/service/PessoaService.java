package marks.gerenciamentopessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.CEP;
import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.repository.cepRepository;
import marks.gerenciamentopessoa.repository.dependenteRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;

@Service
public class PessoaService {
  @Autowired
  private pessoaRepository pessoaRepository;

  @Autowired
  private cepRepository cepRepository;

  @Autowired
  private dependenteRepository dependenteRepository;

  public Boolean save(Pessoa pessoa) {
    verifCepExiste(pessoa);
    if(testeCpfExiste(pessoa)) {
      pessoaRepository.save(pessoa);
      return true;
    }
    return false;
  }

  public Optional<Pessoa> findById(Long id) {
    return pessoaRepository.findById(id);
  }

  public List<Pessoa> findAll() {
    return pessoaRepository.findAll();
  }

  public Boolean atualiza(Pessoa pessoa, Long id_sessao) {
    if(testeCpfSessao(id_sessao, pessoa) || testeCpfExiste(pessoa)) {
      pessoaRepository.save(pessoa);
      return true;
    }
    return false;
  }

  public void remove(Long id) {
    pessoaRepository.deleteById(id);
  }

  //Funcoes de teste
  public Boolean testeCpfExiste(Pessoa pessoa) {
    if(pessoaRepository.findByCpf(pessoa.getCpf()) == null && dependenteRepository.findByCpf(pessoa.getCpf()) == null ) {
      return true;
    } 
    return false;
  }

  public Boolean testeCpfSessao(Long id, Pessoa pessoa) {
    if(pessoaRepository.findById(id).get().getCpf().equals(pessoa.getCpf())) {
      return true;
    } 
    return false;
  }

  public void verifCepExiste(Pessoa pessoa) {
    List<CEP> tempRepoCep = cepRepository.findAllByNumeroCep(pessoa.getEndereco().getCep().getNumeroCep());

    for (CEP item : tempRepoCep) {
      if (item != null) {
        CEP tmpPessoaCep = pessoa.getEndereco().getCep();
        if (normalizaString(item.getEstado()).equals(normalizaString(tmpPessoaCep.getEstado()))
            && normalizaString(item.getMunicipio()).equals(normalizaString(tmpPessoaCep.getMunicipio()))
            && normalizaString(item.getBairro()).equals(normalizaString(tmpPessoaCep.getBairro()))) {
          pessoa.getEndereco().setCep(item);
        } else {
          cepRepository.save(pessoa.getEndereco().getCep());
        }
      }
    }
  }

  public String normalizaString(String s) {
    return s = s.toLowerCase().trim();
  }
}
