package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.time.LocalDateTime;

public class DTONotificação {

    private Long id;
    private String tipo;
    private String equipamento;
    private String funcionario;
    private LocalDateTime dataAgendamento;

    public DTONotificação(Long id, String equipamento, String funcionario, String tipo, LocalDateTime dataAgendamento) {
        this.id = id;
        this.equipamento = equipamento;
        this.funcionario = funcionario;
        this.tipo = tipo;
        this.dataAgendamento = dataAgendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
