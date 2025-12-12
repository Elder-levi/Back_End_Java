package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.time.LocalDateTime;

public class OSDto {

    private String tipo;
    private Long funcionarioId;
    private Long equipamentoId;
    private LocalDateTime dataAgendamento  ;

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
         this.dataAgendamento = dataAgendamento;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Long getFuncionarioId() {
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
