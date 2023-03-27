package br.com.farmacos.restspringbootcontrolefamacos.usuario;


import br.com.farmacos.restspringbootcontrolefamacos.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
		@NotNull
		Long id,
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotNull
		@Valid
		DadosEndereco endereco
		) {

}
