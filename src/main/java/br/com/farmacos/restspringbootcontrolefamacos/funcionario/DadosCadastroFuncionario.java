package br.com.farmacos.restspringbootcontrolefamacos.funcionario;

import br.com.farmacos.restspringbootcontrolefamacos.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroFuncionario(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @CPF
        String cpf,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {

}
