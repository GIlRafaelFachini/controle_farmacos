package br.com.farmacos.restspringbootcontrolefamacos.services;


import br.com.farmacos.restspringbootcontrolefamacos.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {

	@Autowired
	private RemedioRepository repository;
	
	public void validacaoQuantidade(Integer quantidade) {
		if (quantidade == null) {
			throw new RuntimeException("Parâmetro quantidade é obrigatório");
		}
	}
	
	public void adicionarQuantidade(Long id, int quantidade) {
		validacaoQuantidade(quantidade);
		var remedio = repository.getReferenceById(id);
		remedio.addQuantidade(quantidade);
		repository.save(remedio);
	}
	
	public void removerQuantidade(Long id, int quantidade) {
		validacaoQuantidade(quantidade);
		var remedio = repository.getReferenceById(id);
		remedio.removeQuantidade(quantidade);
		repository.save(remedio);
	}
}
