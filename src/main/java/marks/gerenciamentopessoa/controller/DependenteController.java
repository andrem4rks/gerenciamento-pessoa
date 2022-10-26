package marks.gerenciamentopessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import marks.gerenciamentopessoa.model.Dependente;
import marks.gerenciamentopessoa.repository.sexoRepository;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private sexoRepository sexoRepository;

    @GetMapping("/novo")
    public String adicionarDependente(Model model){
      model.addAttribute("dependente", new Dependente());
      popularAtributos(model);
      return "/cadastrar-dependente";
    } 

    public void popularAtributos(Model model) {
        model.addAttribute("listaSexo", sexoRepository.findAll());
    }
}
