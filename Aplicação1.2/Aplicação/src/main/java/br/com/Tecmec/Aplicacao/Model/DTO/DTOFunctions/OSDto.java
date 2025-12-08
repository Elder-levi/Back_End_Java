package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

public class OSDto {

    private String tipo;
    private long funcionarioId;
    private long equipamnetoId;

    public long getEquipamnetoId() {
        return equipamnetoId;
    }

    public void setEquipamnetoId(long equipamnetoId) {
        this.equipamnetoId = equipamnetoId;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
