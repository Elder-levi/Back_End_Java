package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import br.com.Tecmec.Aplicacao.Model.Enums.Status;

public class EncerrarOSDTO {
    private long id;
    private long funcionarioId;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}
