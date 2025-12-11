package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.time.LocalDateTime;

public class DTOporEquip {



    private Long Codigo;
    private String Tipo;
    private String Status;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataAgendamento;
    private LocalDateTime dataEncerramento;

    private String funcionarioNome;

    public DTOporEquip(Long codigo, String status, String tipo, LocalDateTime dataAbertura, LocalDateTime dataAgendamento, LocalDateTime dataEncerramento, String funcionarioNome) {
        Codigo = codigo;
        Status = status;
        Tipo = tipo;
        this.dataAbertura = dataAbertura;
        this.dataAgendamento = dataAgendamento;
        this.dataEncerramento = dataEncerramento;
        this.funcionarioNome = funcionarioNome;
    }

    public String getStatus() {
        return Status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public String getTipo() {
        return Tipo;
    }

    public Long getCodigo() {
        return Codigo;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }
}
