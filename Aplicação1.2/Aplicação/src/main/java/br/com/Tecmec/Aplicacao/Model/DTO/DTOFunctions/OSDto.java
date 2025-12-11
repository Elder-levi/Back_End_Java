package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import br.com.Tecmec.Aplicacao.Exception.BadRequestException;
import br.com.Tecmec.Aplicacao.Model.Enums.Tipo;

import java.time.LocalDateTime;

public class OSDto {

    private Tipo tipo;
    private Long funcionarioId;
    private Long equipamentoId;
    private LocalDateTime dataAgendamento  ;

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
         this.dataAgendamento = dataAgendamento;
    }

    public long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
