package marks.gerenciamentopessoa.config;

import marks.gerenciamentopessoa.model.Usuario;
import marks.gerenciamentopessoa.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService {

  @Autowired
  usuarioRepository usuarioRepository;

  @Override
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByUsername(username).
        orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!" + username));
    return usuario;
  }
}
