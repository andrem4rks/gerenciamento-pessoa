package marks.gerenciamentopessoa.config;

import marks.gerenciamentopessoa.model.Usuario;
import marks.gerenciamentopessoa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Usuario usuario = usuarioRepository.findByUsername(username).get();
    return usuario;
  }

}