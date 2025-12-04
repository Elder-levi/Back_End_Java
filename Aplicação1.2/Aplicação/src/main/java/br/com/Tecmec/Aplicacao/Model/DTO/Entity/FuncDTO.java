package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.Funcionario;

public class FuncDTO {

    public long id ;
    public String nome;
    public String Cargo;

    public FuncDTO(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.Cargo = f.getCargo();
    }
}
