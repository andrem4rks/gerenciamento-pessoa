package marks.gerenciamentopessoa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

  @RequestMapping(path = { "", "/login"}, method = { RequestMethod.GET, RequestMethod.POST })
  public String login(Authentication authentication) {
    if (authentication == null)
      return "login";

    return "redirect:/home";
  }

}
