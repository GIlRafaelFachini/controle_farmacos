package br.com.farmacos.restspringbootcontrolefamacos.remedio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRemedio(
		@NotNull
		Long id,

		String nome,
		
		Via via,
		
		Laboratorio laboratorio) {
	
	

}
