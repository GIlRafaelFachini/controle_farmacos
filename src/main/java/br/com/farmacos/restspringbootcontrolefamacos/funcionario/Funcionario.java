package br.com.farmacos.restspringbootcontrolefamacos.funcionario;

import br.com.farmacos.restspringbootcontrolefamacos.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "funcionarios")
@Entity(name = "Funcionario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Funcionario {

    public Funcionario(DadosCadastroFuncionario dados) {
        this.nome = dados.nome ();
        this.email = dados.email ();
        this.cpf = dados.cpf ();
        this.especialidade = dados.especialidade ();
        this.ativo = true;
        this.endereco = new Endereco (dados.endereco ());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotBlank
    private String nome;
    @Email
    @NotNull
    private String email;
    @CPF
    private String cpf;
    private boolean ativo;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Especialidade especialidade;

    @Embedded
    @NotNull
    @Valid
    private Endereco endereco;

    public void atualizarInformacoes(@Valid DadosAtualizacaoFuncionario dados) {
        if (dados.nome () != null) {
            this.nome = dados.nome ();
        }
        if (dados.email () != null) {
            this.email = dados.email ();
        }
        if (dados.endereco () != null) {
            this.endereco.atualizarInformacoes (dados.endereco ());
        }

    }

    public void setAtivo() {
        this.ativo = true;
    }

    public void setInativo() {
        this.ativo = false;
    }

}
