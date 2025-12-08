package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.Funcionario;

public class FuncDTO {

    private long id ;
    private String nome;
    private String Cargo;

    public FuncDTO(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.Cargo = f.getCargo();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
