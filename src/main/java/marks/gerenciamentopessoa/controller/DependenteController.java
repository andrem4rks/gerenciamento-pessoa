package marks.gerenciamentopessoa.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.service.DependenteService;
import marks.gerenciamentopessoa.service.PessoaService;
import marks.gerenciamentopessoa.service.SexoService;
import marks.gerenciamentopessoa.service.TipoDependenteService;

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
  private TipoDependenteService tipoDependenteService;

  @RequestMapping(path = "/novo", method = RequestMethod.GET)
  public String adicionarDependente(Model model, HttpSession session) {
    Long id_representante = Long.parseLong(session.getAttribute("id_representante").toString());
    model.addAttribute("dependente", new Dependente());
    model.addAttribute("cpfRepresentante", pessoaService.findById(id_representante).get().getCpf());
    popularAtributos(model);
    return "dependente/cadastrar-dependente";
  }

  @RequestMapping(path = "/salvar", method = RequestMethod.POST)
  public String salvarDependente(@Valid Dependente dependente,
      BindingResult result,
      RedirectAttributes attributes,
      Model model,
      RedirectAttributes attr,
      HttpSession session) {
    popularAtributos(model);
    Long id_representante = Long.parseLong(session.getAttribute("id_representante").toString());
    if (!(dependenteService.save(dependente, id_representante))) {
      result.addError(new FieldError("pessoa", "cpf", "CPF já existe cadastrado!"));
    }
    if (result.hasErrors()) {
      return "dependente/cadastrar-dependente";
    }
    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente cadastrado com sucesso!");
    return "redirect:/dependente/listar/" + id_representante;
  }

  @RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
  public String listarPessoas(@PathVariable("id") Long id, Model model, HttpSession session) {
    model.addAttribute("dependentes", pessoaService.findById(id).get().getDependente());
    model.addAttribute("nomeRepresentante", pessoaService.findById(id).get().getNome());
    session.setAttribute("id_representante", id);
    return "dependente/listar-dependentes";
  }

  @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
  public String editarDependente(@PathVariable("id") Long id, Model model, HttpSession session) {
    Dependente dependente = dependenteService.findById(id).get();
    session.setAttribute("id_sessao", dependente.getId());
    model.addAttribute("dependente", dependente);
    popularAtributos(model);
    return "dependente/cadastrar-dependente";
  }

  @RequestMapping(path = "/atualizar/{id}", method = RequestMethod.POST)
  public String editarDependente(@PathVariable("id") Long id, @Valid Dependente dependente, BindingResult result, RedirectAttributes attr, HttpSession session) {
    Long id_sessao = Long.parseLong(session.getAttribute("id_sessao").toString());
    Long id_representante = Long.parseLong(session.getAttribute("id_representante").toString());
    if (!(dependenteService.atualiza(dependente, id_sessao, id_representante))) {
      result.addError(new FieldError("pessoa", "cpf", "CPF já existe cadastrado!"));
    }
    if (result.hasErrors()) {
      return "dependente/cadastrar-dependente";
    }
    dependente.setPessoa(pessoaService.findById(id_representante).get());
    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente editado com sucesso!");
    return "redirect:/dependente/listar/" + id_representante;
  }

  @RequestMapping(path = "/apagar/{id}", method = RequestMethod.GET)
  public String apagarDependente(@PathVariable("id") Long id, Model model, RedirectAttributes attr, HttpSession session) {
    dependenteService.remove(id);
    Long id_representante = Long.parseLong(session.getAttribute("id_representante").toString());
    attr.addFlashAttribute("alertIcon", "success");
    attr.addFlashAttribute("alertMessage", "Dependente apagado com sucesso!");
    return "redirect:/dependente/listar/" + id_representante;
  }

  public void popularAtributos(Model model) {
    model.addAttribute("listaTipo", tipoDependenteService.findAll());
    model.addAttribute("listaSexo", sexoService.findAll());
  }
}
