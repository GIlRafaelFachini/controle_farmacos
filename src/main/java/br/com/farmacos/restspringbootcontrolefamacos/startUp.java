package br.com.farmacos.restspringbootcontrolefamacos;

import br.com.farmacos.restspringbootcontrolefamacos.endereco.DadosEndereco;
import br.com.farmacos.restspringbootcontrolefamacos.services.PasswordEncryptionService;
import br.com.farmacos.restspringbootcontrolefamacos.usuario.DadosCadastroUsuario;
import br.com.farmacos.restspringbootcontrolefamacos.usuario.Usuario;
import br.com.farmacos.restspringbootcontrolefamacos.usuario.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SpringBootApplication
public class startUp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(startUp.class, args);

//		var usuario = context.getBean(UsuarioRepository.class).findByNome("admin");
//		if (usuario == null) {
//			var senha = context.getBean(PasswordEncryptionService.class).encryptPassword ("admin");
//
//			var dadosCadastroUsuario = new DadosCadastroUsuario(
//					"admin",
//					"admin",
//					senha,
//					"admin@admin.com",
//					"007878978541",
//					new DadosEndereco (
//							"89210-300",
//							"SC",
//							"Jariva",
//							"Cardoso",
//							"esquina",
//							"12"));
//			var novoUsuario = new Usuario (dadosCadastroUsuario);
//			context.getBean(UsuarioRepository.class).save(novoUsuario);
//		}
	}

}
