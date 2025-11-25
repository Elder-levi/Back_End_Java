package br.com.Tecmec.Aplicacao.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Funcionarios")
@Data
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

    public Funcionario() {}

    public Funcionario(String nome, String Cargo, String Login, String Senha) {
        this.nome = nome;
        this.Cargo = Cargo;
        this.Login = Login;
        this.Senha = Senha;

    }
}



