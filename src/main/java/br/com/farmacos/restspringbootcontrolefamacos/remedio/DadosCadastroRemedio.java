package br.com.farmacos.restspringbootcontrolefamacos.remedio;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroRemedio(
		
		@NotBlank
		String nome,
		@NotNull
		Via via,
		@NotBlank
		String lote,
		
		int quantidade,
		
		@Future
		LocalDate validade,
		@NotNull
		Laboratorio laboratorio
		) {

	public String Getnome() {
		return nome;
	}
	
	
	

}
