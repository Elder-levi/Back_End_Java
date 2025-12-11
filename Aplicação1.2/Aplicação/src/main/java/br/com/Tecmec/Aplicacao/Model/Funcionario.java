package br.com.Tecmec.Aplicacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Funcionarios")

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_matricula")
    private Long id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "email")
    private String login;

    @Column(name = "senha")
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private Set<OS> os = new HashSet<>();

    public Funcionario() {}

    public Funcionario(String senha, String login, String cargo, String nome) {
        this.senha = senha;
        this.login = login;
        this.cargo = cargo;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OS> getOs() {
        return os;
    }

    public void setOs(Set<OS> os) {
        this.os = os;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}



