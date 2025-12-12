package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.OS;


import java.time.LocalDateTime;

public class OSResponseDTO {

    private Long id_os;
    private String tipo;
    private String status;

    private LocalDateTime data_Abertura;
    private LocalDateTime data_Agendamento;
    private LocalDateTime data_Encerramento;

    private FuncDTO funcionario;
    private EquipamentoDTO equipamento;

    public OSResponseDTO(OS os) {

        this.id_os = os.getId_os();
        this.tipo = os.getTipo();
        this.status = os.getStatus().name();

        this.data_Abertura = os.getDataAbertura();
        this.data_Agendamento = os.getDataAgendamento();
        this.data_Encerramento = os.getDataEncerramento();

        this.funcionario = new FuncDTO(os.getFuncionario());
        this.equipamento = new EquipamentoDTO(os.getEquipamento());
    }

    public EquipamentoDTO getEquipamento() {
        return equipamento;
    }

    public FuncDTO getFuncionario() {
        return funcionario;
    }

    public LocalDateTime getData_Encerramento() {
        return data_Encerramento;
    }

    public LocalDateTime getData_Abertura() {
        return data_Abertura;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getData_Agendamento() {
        return data_Agendamento;
    }

    public Long getId_os() {
        return id_os;
    }

    public String getTipo() {
        return tipo;
    }
}