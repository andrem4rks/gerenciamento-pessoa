package marks.gerenciamentopessoa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.repository.dependenteRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;
import marks.gerenciamentopessoa.repository.sexoRepository;
import marks.gerenciamentopessoa.repository.tipoDependenteRepository;

@Controller
@RequestMapping("/dependente")
public class DependenteController {
  @Autowired
  private dependenteRepository dependenteRepository;

  @Autowired
  private pessoaRepository pessoaRepository;

  @Autowired
  private sexoRepository sexoRepository;

  @Autowired
  private tipoDependenteRepository tipoDependenteRepository;

  private Long globalId;

  @GetMapping("/novo")
  public String adicionarDependente(Model model) {
    model.addAttribute("dependente", new Dependente());
    model.addAttribute("cpfRepresentante", pessoaRepository.findById(globalId).get().getCpf());
    popularAtributos(model);
    return "/cadastrar-dependente";
  }

  @RequestMapping("/listar/{id}")
  public String listarPessoas(@PathVariable("id") Long id, Model model) {
    model.addAttribute("dependentes", pessoaRepository.findById(id).get().getDependentes());
    model.addAttribute("nomeRepresentante", pessoaRepository.findById(id).get().getNome());
    globalId = id;
    return "listar-dependentes";
  }

  @PostMapping("/salvar")
  public String salvarPessoa(@Valid Dependente dependente,
      BindingResult result,
      RedirectAttributes attributes,
      Model model) {
    popularAtributos(model);

    if (result.hasErrors()) {
      return "cadastrar-dependente";
    }

    List<Dependente> dependentes = new ArrayList<Dependente>();
    dependentes = pessoaRepository.findById(globalId).get().getDependentes();
    dependentes.add(dependente);
    dependenteRepository.save(dependente);
    pessoaRepository.findById(globalId).get().setDependentes(dependentes);
    // setRelations(pessoa);
    return "redirect:/dependente/listar/" + globalId;
  }

  @GetMapping("/apagar/{id}")
  public String apagarDependente(@PathVariable("id") Long id, Model model) {
    List<Dependente> dependentes = new ArrayList<Dependente>();
    dependenteRepository.deleteById(id);
    return "redirect:/listar/" + globalId;
  }

  public void popularAtributos(Model model) {
    model.addAttribute("listaTipo", tipoDependenteRepository.findAll());
    model.addAttribute("listaSexo", sexoRepository.findAll());
  }
}
