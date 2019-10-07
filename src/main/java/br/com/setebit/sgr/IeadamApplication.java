package br.com.setebit.sgr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.setebit.sgr.repository.UsuarioRepositorio;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.enums.ProfileEnum;

@SpringBootApplication
public class IeadamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IeadamApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepositorio rep, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsuario(rep, passwordEncoder);
		};

	}

	private void initUsuario(UsuarioRepositorio rep, PasswordEncoder passwordEncoder) {
		Usuario admin = new Usuario();
		admin.setEmail("admin@gmail.com");
		admin.setSenha(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		admin.setArea(true);
		admin.setLogin("admin");
		admin.setNome("Administrador");
		admin.setNucleo(true);
		admin.setStatus("1");
		admin.setZona(true);

		Usuario find = rep.findByEmail("admin@gmail.com");
		if (find == null) {
			rep.save(admin);
		}
	}
}
