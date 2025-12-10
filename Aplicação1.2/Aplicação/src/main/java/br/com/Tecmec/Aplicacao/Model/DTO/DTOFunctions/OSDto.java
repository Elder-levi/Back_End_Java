package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.time.LocalDateTime;

public class OSDto {

    private String tipo;
    private long funcionarioId;
    private long equipamnetoId;
    private LocalDateTime dataAgendamento  ;

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
       
        LocalDateTime minino = LocalDateTime.now()..plusDays(7)
        if(dataAgendamento..isBefore(minimo))
        {
          throw new IllegalArgumentException("A data de agendamento deve ter no mínimo 7 dias de antecedência.");   
        } this.dataAgendamento = dataAgendamento;

        
    }

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
