package marks.gerenciamentopessoa.controller;

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

import marks.gerenciamentopessoa.model.CEP;
import marks.gerenciamentopessoa.model.CadastroPessoa;
import marks.gerenciamentopessoa.model.Endereco;
import marks.gerenciamentopessoa.model.EstadoCivil;
import marks.gerenciamentopessoa.model.Pais;
import marks.gerenciamentopessoa.model.Pessoa;
import marks.gerenciamentopessoa.model.Raca;
import marks.gerenciamentopessoa.model.Sexo;
import marks.gerenciamentopessoa.model.TipoEndereco;
import marks.gerenciamentopessoa.repository.cepRepository;
import marks.gerenciamentopessoa.repository.enderecoRepository;
import marks.gerenciamentopessoa.repository.estadoCivilRepository;
import marks.gerenciamentopessoa.repository.paisRepository;
import marks.gerenciamentopessoa.repository.pessoaRepository;
import marks.gerenciamentopessoa.repository.sexoRepository;
import marks.gerenciamentopessoa.repository.tipoEnderecoRepository;
import marks.gerenciamentopessoa.repository.racaRepository;

@Controller
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

    @Autowired
    private enderecoRepository enderecoRepository;
    
    @GetMapping("/novo")
    public String adicionarPessoa(Model model){
      
      model.addAttribute("cadastroPessoa", new CadastroPessoa());
      model.addAttribute("listaSexo", sexoRepository.findAll());
      model.addAttribute("listaRaca", racaRepository.findAll());
      model.addAttribute("listaEstadoCivil", estadoCivilRepository.findAll());
      model.addAttribute("listaPaises", paisRepository.findAll());
      model.addAttribute("listaTipoEndereco", tipoEnderecoRepository.findAll());
      return "/cadastrar-pessoa";
    } 

    
    @PostMapping("/salvar")
    public String salvarPessoa( @Valid CadastroPessoa cadastroPessoa,
                                BindingResult result,
                                RedirectAttributes attributes )  
                                {
      
      if (result.hasErrors()) {
			  return "cadastrar-pessoa";
		  }

      return "redirect:/novo";
    }

    @RequestMapping("/listar")
    public String listarPessoas(Model model) {
      model.addAttribute("pessoas", pessoaRepository.findAll());
      return "listar-pessoas";
    }

    @GetMapping("/apagar/{id}")
    public String apagarUsuario(@PathVariable("id") Long id, Model model) {
      pessoaRepository.deleteById(id);
      return "redirect:/listar";
    }

    public void setRelations(Pessoa pessoa,Endereco endereco, Long sexo_id, Long raca_id, Long estadoCivil_id, Long paisNascimento_id, Long paisNacionalidade_id, Long tipoEndereco_id) {
      Optional<Sexo> sexoOptional = sexoRepository.findById(sexo_id);
      Sexo sexo = sexoOptional.get();
      pessoa.setSexo(sexo);

      Optional<Raca> racaOptional = racaRepository.findById(raca_id);
      Raca raca = racaOptional.get();
      pessoa.setRaca(raca);

      Optional<EstadoCivil> estadoCivilOptional = estadoCivilRepository.findById(estadoCivil_id);
      EstadoCivil estadoCivil = estadoCivilOptional.get();
      pessoa.setEstadoCivil(estadoCivil);

      Optional<Pais> paisNascimentoOptional = paisRepository.findById(paisNascimento_id);
      Pais paisNascimento = paisNascimentoOptional.get();
      pessoa.setPaisNascimento(paisNascimento);

      Optional<Pais> paisNacionalidadeOptional = paisRepository.findById(paisNacionalidade_id);
      Pais paisNacionalidade = paisNacionalidadeOptional.get();
      pessoa.setPaisNacionalidade(paisNacionalidade);

      Optional<TipoEndereco> tipoEnderecoOptional = tipoEnderecoRepository.findById(tipoEndereco_id);
      TipoEndereco tipoEndereco = tipoEnderecoOptional.get();
      endereco.setTipoEndereco(tipoEndereco);
    }
}

 /*setRelations(pessoa, endereco, sexo_id, raca_id, estadoCivil_id, paisNascimento_id, paisNacionalidade_id, tipoEndereco_id);
      CEP cepTmp = cepRepository.findByCep(cep.getCep());
      if(cepTmp != null) {
        if(cep.getEstado() == cepTmp.getEstado() && cep.getMunicipio() == cepTmp.getMunicipio() && cep.getBairro() == cepTmp.getBairro()) {
          endereco.setCep(cepTmp);
        } 
      } else {
        cepRepository.save(cep);
        endereco.setCep(cep);
      }
      enderecoRepository.save(endereco);
      pessoa.setEndereco(endereco);
      pessoaRepository.save(pessoa);
      */