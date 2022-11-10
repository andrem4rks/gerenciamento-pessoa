package marks.gerenciamentopessoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marks.gerenciamentopessoa.model.CEP;
import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.repository.cepRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;

@Service
public class PessoaService {
  @Autowired
  private pessoaRepository pessoaRepository;

  @Autowired
  private cepRepository cepRepository;

  public Pessoa save(Pessoa pessoa) {
    verifCepExiste(pessoa);
    return pessoaRepository.save(pessoa);
  }

  public Optional<Pessoa> findById(Long id) {
    return pessoaRepository.findById(id);
  }

  public List<Pessoa> findAll() {
    return pessoaRepository.findAll();
  }

  public void remove(Long id) {
    pessoaRepository.deleteById(id);
  }

  public Pessoa verifCepExiste(Pessoa pessoa) {
    List<CEP> tempRepoCep = cepRepository.findAllByNumeroCep(pessoa.getEndereco().getCep().getNumeroCep());

    for (CEP item : tempRepoCep) {
      if (item != null) {
        CEP tmpPessoaCep = pessoa.getEndereco().getCep();
        if (normalizaString(item.getEstado()).equals(normalizaString(tmpPessoaCep.getEstado()))
            && normalizaString(item.getMunicipio()).equals(normalizaString(tmpPessoaCep.getMunicipio()))
            && normalizaString(item.getBairro()).equals(normalizaString(tmpPessoaCep.getBairro()))) {
          pessoa.getEndereco().setCep(item);
          return pessoa;
        }
      }
    }
    cepRepository.save(pessoa.getEndereco().getCep());
    return pessoa;
  }

  public String normalizaString(String s) {
    return s = s.toLowerCase().trim();
  }
}
