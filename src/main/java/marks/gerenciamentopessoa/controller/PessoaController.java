package marks.gerenciamentopessoa.controller;

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

import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.repository.pessoaRepository;

@Controller
public class PessoaController {

    @Autowired
    private pessoaRepository pessoaRepository;
    
    @GetMapping("/novo")
    public String adicionarPessoa(Model model){
      model.addAttribute("pessoa", new Pessoa());
      //model.addAttribute("paises", paisesRepository.findAll());
      return "cadastrar-pessoa";
    } 
    
    @PostMapping("/salvar")
    public String salvarPessoa(@Valid Pessoa pessoa, BindingResult result,
    Model model, RedirectAttributes attributes) {

      if(result.hasErrors()) {
        return "redirect:/novo";
      }

      pessoaRepository.save(pessoa);
      
      return "redirect:/novo";
    }

    @RequestMapping("/listar")
    public String listarPessoas(Model model) {
      model.addAttribute("pessoas", pessoaRepository.findAll());
      return "listar-pessoas";
    }

    @GetMapping("/apagar/{id}")
    public String apagarUsuario(@PathVariable("id") Long id ,Model model) {
      pessoaRepository.deleteById(id);
      return "redirect:/listar";
    }
}
