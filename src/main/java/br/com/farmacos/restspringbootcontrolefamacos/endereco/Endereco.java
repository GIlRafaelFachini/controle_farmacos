package br.com.farmacos.restspringbootcontrolefamacos.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotBlank
    private String uf;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep ();
        this.uf = dados.uf ();
        this.cidade = dados.cidade ();
        this.bairro = dados.bairro ();
        this.complemento = dados.complemento ();
        this.numero = dados.numero ();

    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.cep () != null) {
            this.cep = dados.cep ();
        }
        if (dados.uf () != null) {
            this.uf = dados.uf ();
        }
        if (dados.cidade () != null) {
            this.cidade = dados.cidade ();
        }
        if (dados.bairro () != null) {
            this.bairro = dados.bairro ();
        }
        if (dados.complemento () != null) {
            this.complemento = dados.complemento ();
        }
        if (dados.numero () != null) {
            this.numero = dados.numero ();
        }
    }

}
