package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.time.LocalDateTime;

public class DTOporEquip {

    private Long codigoOs;
    private String tipo;
    private String status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataAgendamento;
    private LocalDateTime dataEncerramento;
    private String funcionarioNome;

    public DTOporEquip(Long codigoOs, String tipo, String status,
                       LocalDateTime dataAbertura, LocalDateTime dataAgendamento,
                       LocalDateTime dataEncerramento, String funcionarioNome) {

        this.codigoOs = codigoOs;
        this.tipo = tipo;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataAgendamento = dataAgendamento;
        this.dataEncerramento = dataEncerramento;
        this.funcionarioNome = funcionarioNome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCodigoOs() {
        return codigoOs;
    }

    public void setCodigoOs(Long codigoOs) {
        this.codigoOs = codigoOs;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }
}
