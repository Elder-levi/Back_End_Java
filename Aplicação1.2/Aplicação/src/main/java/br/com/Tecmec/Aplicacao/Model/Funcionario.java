package br.com.Tecmec.Aplicacao.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Funcionarios")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_matricula")
    private Long Id;

    @Column(name = "Usuario_nome")
    private String nome;

    private String Cargo;

    @Column(name = "email")
    private String Login;

    private String Senha;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private Set<OS> os = new HashSet<>();


    public Funcionario() {}

    public Funcionario(String nome, String Cargo, String Login, String Senha) {
        this.nome = nome;
        this.Cargo = Cargo;
        this.Login = Login;
        this.Senha = Senha;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<OS> getOs() {
        return os;
    }

    public void setOs(Set<OS> os) {
        this.os = os;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}



