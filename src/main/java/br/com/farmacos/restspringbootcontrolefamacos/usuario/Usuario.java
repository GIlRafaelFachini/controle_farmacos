package br.com.farmacos.restspringbootcontrolefamacos.usuario;

import br.com.farmacos.restspringbootcontrolefamacos.endereco.Endereco;
import br.com.farmacos.restspringbootcontrolefamacos.services.CpfJaCadastrado;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome ();
        this.login = dados.login ();
        this.senha = dados.senha ();
        this.email = dados.email ();
        this.cpf = dados.cpf ();
        this.ativo = true;
        this.endereco = new Endereco (dados.endereco ());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 6, max = 30)
    private String senha;
    @NotBlank
    private String email;
    @CPF
    @CpfJaCadastrado
    private String cpf;
    private boolean ativo;

    @Embedded
    @NotNull
    @Valid
    private Endereco endereco;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of (new SimpleGrantedAuthority ("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setSenha(String senhaCriptografada) {
        this.senha = senhaCriptografada;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoUsuario dados) {
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
