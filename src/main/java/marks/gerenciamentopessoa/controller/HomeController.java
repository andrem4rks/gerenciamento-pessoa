package marks.gerenciamentopessoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String index(Model model) {
        model.addAttribute("msgBemVindo", "Bem-vindo!");
        return "home";
    }

}

