package marks.gerenciamentopessoa.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.model.Raca;
import marks.gerenciamentopessoa.model.Sexo;
import marks.gerenciamentopessoa.repository.pessoaRepository;
import marks.gerenciamentopessoa.repository.sexoRepository;
import marks.gerenciamentopessoa.repository.racaRepository;

@Controller
public class PessoaController {

    @Autowired
    private pessoaRepository pessoaRepository;

    @Autowired
    private sexoRepository sexoRepository;

    @Autowired
    private racaRepository racaRepository;
    
    
    @GetMapping("/novo")
    public String adicionarPessoa(Model model){
      model.addAttribute("pessoa", new Pessoa());
      model.addAttribute("listaSexo", sexoRepository.findAll());
      model.addAttribute("listaRaca", racaRepository.findAll());
      return "cadastrar-pessoa";
    } 
    
    @PostMapping("/salvar")
    public String salvarPessoa(@Valid Pessoa pessoa, 
                                BindingResult result,
                                Model model, 
                                RedirectAttributes attributes, 
                                @RequestParam (value = "sexo", required = true) Long sexo_id,
                                @RequestParam (value = "raca", required = true) Long raca_id ) {
      if(result.hasErrors()) {
        return "redirect:/novo";
      }


      Optional<Sexo> sexoOptional = sexoRepository.findById(sexo_id);
      Sexo sexo = sexoOptional.get();
      pessoa.setSexo(sexo);

      Optional<Raca> racaOptional = racaRepository.findById(raca_id);
      Raca raca = racaOptional.get();
      pessoa.setRaca(raca);

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
