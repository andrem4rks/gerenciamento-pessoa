package marks.gerenciamentopessoa.controller;

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

import marks.gerenciamentopessoa.model.CEP;
import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.repository.cepRepository;
import marks.gerenciamentopessoa.repository.estadoCivilRepository;
import marks.gerenciamentopessoa.repository.paisRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;
import marks.gerenciamentopessoa.repository.sexoRepository;
import marks.gerenciamentopessoa.repository.tipoEnderecoRepository;
import marks.gerenciamentopessoa.repository.racaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private pessoaRepository pessoaRepository;

    @Autowired
    private sexoRepository sexoRepository;

    @Autowired
    private racaRepository racaRepository;

    @Autowired
    private paisRepository paisRepository;

    @Autowired
    private tipoEnderecoRepository tipoEnderecoRepository;
    
    @Autowired
    private estadoCivilRepository estadoCivilRepository;

    @Autowired
    private cepRepository cepRepository;

    @GetMapping("/novo")
    public String adicionarPessoa(Model model){
      model.addAttribute("pessoa", new Pessoa());
      popularAtributos(model);
      return "/cadastrar-pessoa";
    } 

    
    @PostMapping("/salvar")
    public String salvarPessoa( @Valid Pessoa pessoa,
                                BindingResult result,
                                RedirectAttributes attributes,
                                Model model
                                )  
                                {
      popularAtributos(model);      

      if (result.hasErrors()) {
			  return "cadastrar-pessoa";
		  }
      verifCepExiste(pessoa);
      pessoaRepository.save(pessoa);
      //setRelations(pessoa);

      return "redirect:/pessoa/novo";
    }

    @RequestMapping("/listar")
    public String listarPessoas(Model model) {
      model.addAttribute("pessoas", pessoaRepository.findAll());
      return "listar-pessoas";
    }

    @GetMapping("/apagar/{id}")
    public String apagarUsuario(@PathVariable("id") Long id, Model model) {
      pessoaRepository.deleteById(id);
      return "redirect:/pessoa/listar";
    }

    public void popularAtributos(Model model) {
      model.addAttribute("listaSexo", sexoRepository.findAll());
      model.addAttribute("listaRaca", racaRepository.findAll());
      model.addAttribute("listaEstadoCivil", estadoCivilRepository.findAll());
      model.addAttribute("listaPaises", paisRepository.findAll());
      model.addAttribute("listaTipoEndereco", tipoEnderecoRepository.findAll());
    }

    public Pessoa verifCepExiste(Pessoa pessoa) {
      List<CEP> tempRepoCep  = cepRepository.findAllByNumeroCep(pessoa.getEndereco().getCep().getNumeroCep());
    
      for (CEP item : tempRepoCep) {
        if(item != null) {
          CEP tmpPessoaCep = pessoa.getEndereco().getCep();
          if ( normalizaString(item.getEstado()).equals(normalizaString(tmpPessoaCep.getEstado()))
              && normalizaString(item.getMunicipio()).equals(normalizaString(tmpPessoaCep.getMunicipio())) 
              && normalizaString(item.getBairro()).equals(normalizaString(tmpPessoaCep.getBairro()))    
             )  {
            pessoa.getEndereco().setCep(item);
            return pessoa;
          }
        }
      }
      cepRepository.save(pessoa.getEndereco().getCep());
      return pessoa;
    }

    public String normalizaString(String s) {
      return  s = s.toLowerCase().trim();
    }
}

/*
              
 */