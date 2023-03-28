package br.com.farmacos.restspringbootcontrolefamacos.remedio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="remedios")
@Entity(name="remedio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Remedio {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	private long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String lote;
	@Future
	private LocalDate validade;
	private Boolean ativo;
	private int quantidade;
	
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	
	@Enumerated(EnumType.STRING)
	@NotBlank
	private Via via;

	public Remedio(DadosCadastroRemedio dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.lote = dados.lote();
		this.validade = dados.validade();
		this.laboratorio = dados.laboratorio();
		this.via = dados.via();
		this.quantidade = dados.quantidade();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoRemedio dados) {
		if(dados.nome() != null) {
		this.nome = dados.nome();
		}
		if(dados.laboratorio() != null) {
			this.laboratorio = dados.laboratorio();
		}
		if(dados.via() != null) {
			this.via = dados.via();
		}
		
	}

	public void setInativo() {
		this.ativo = false;
	}
	
	public void setAtivo() {
		
		this.ativo = true;
	}

	public void addQuantidade(int quantidade) {
		if(quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade precisa ser positiva.");
		}
		this.quantidade += quantidade;
	}

	public void removeQuantidade(int quantidade) {
		if(quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade precisa ser positiva.");
		}
		if(this.quantidade - quantidade < 0) {
			throw new IllegalArgumentException("A quantidade não pode ser maior do que a existente em estoque.");
		}
		this.quantidade -= quantidade;
	}

	
}
