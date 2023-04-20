package marks.gerenciamentopessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GerenciamentoPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoPessoaApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("admin"));

	}

}

