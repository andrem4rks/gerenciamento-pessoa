package marks.gerenciamentopessoa.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.repository.tipoDependenteRepository;
import marks.gerenciamentopessoa.service.DependenteService;
import marks.gerenciamentopessoa.service.PessoaService;
import marks.gerenciamentopessoa.service.SexoService;

@Controller
@RequestMapping("/dependente")
public class DependenteController {
  @Autowired
  private DependenteService dependenteService;

  @Autowired
  private PessoaService pessoaService;

  @Autowired
  private SexoService sexoService;

  @Autowired
  private tipoDependenteRepository tipoDependenteRepository;

  private Long globalId;

  @RequestMapping(path = "/novo", method = RequestMethod.GET)
  public String adicionarDependente(Model model) {
    model.addAttribute("dependente", new Dependente());
    model.addAttribute("cpfRepresentante", pessoaService.findById(globalId).get().getCpf());
    popularAtributos(model);
    return "dependente/cadastrar-dependente";
  }

  @RequestMapping(path = "/salvar", method = RequestMethod.POST)
  public String salvarDependente(@Valid Dependente dependente,
      BindingResult result,
      RedirectAttributes attributes,
      Model model,
      RedirectAttributes attr) {
    popularAtributos(model);

    if (result.hasErrors()) {
      return "dependente/cadastrar-dependente";
    }

    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente cadastrado com sucesso!");
    dependente.setPessoa(pessoaService.findById(globalId).get());
    dependenteService.save(dependente);

    return "redirect:/dependente/listar/" + globalId;
  }

  @RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
  public String listarPessoas(@PathVariable("id") Long id, Model model) {
    model.addAttribute("dependentes", pessoaService.findById(id).get().getDependente());
    model.addAttribute("nomeRepresentante", pessoaService.findById(id).get().getNome());
    globalId = id;
    return "dependente/listar-dependentes";
  }

  @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
  public String editarDependente(@PathVariable("id") Long id, Model model) {
    Dependente dependente = dependenteService.findById(id).get();
    model.addAttribute("dependente", dependente);
    popularAtributos(model);
    return "dependente/cadastrar-dependente";
  }

  @RequestMapping(path = "/atualizar/{id}", method = RequestMethod.POST)
  public String editarDependente(@PathVariable("id") Long id, @Valid Dependente dependente, BindingResult result, RedirectAttributes attr) {
    if (result.hasErrors()) {
      return "dependente/editar-dependente";
    }
    dependenteService.save(dependente);
    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente editado com sucesso!");
    return "redirect:/dependente/listar/" + globalId;
  }

  @RequestMapping(path = "/apagar/{id}", method = RequestMethod.GET)
  public String apagarDependente(@PathVariable("id") Long id, Model model, RedirectAttributes attr) {
    dependenteService.remove(id);
    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente apagado com sucesso!");
    return "redirect:/dependente/listar/" + globalId;
  }

  public void popularAtributos(Model model) {
    model.addAttribute("listaTipo", tipoDependenteRepository.findAll());
    model.addAttribute("listaSexo", sexoService.findAll());
  }
}
