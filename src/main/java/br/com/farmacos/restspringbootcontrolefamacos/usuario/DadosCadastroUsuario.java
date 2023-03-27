package br.com.farmacos.restspringbootcontrolefamacos.usuario;


import br.com.farmacos.restspringbootcontrolefamacos.endereco.DadosEndereco;
import br.com.farmacos.restspringbootcontrolefamacos.services.CpfJaCadastrado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroUsuario(
		
		@NotBlank
		String nome,
		@NotBlank
		String login,	
		@NotBlank
		@Size(min=6, max=30)
		String senha,	
		@NotBlank
		@Email
		String email,
		@CPF
		@CpfJaCadastrado
		String cpf,
		@NotNull
		@Valid
		DadosEndereco endereco
		) {

}
