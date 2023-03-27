package br.com.farmacos.restspringbootcontrolefamacos.services;

import br.com.farmacos.usuario.Usuario;
import br.com.farmacos.usuario.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;



public class ValidationCPFUserExists implements ConstraintValidator<CpfJaCadastrado, String>{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (cpf == null) {
			return true;
		}
		Optional<Usuario> usuarioExistente = usuarioRepository.findByCpf(cpf);
		return !usuarioExistente.isPresent();
		
	}
}
