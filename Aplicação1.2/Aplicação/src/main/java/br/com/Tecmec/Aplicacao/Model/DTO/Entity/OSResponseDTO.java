package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.Equipamento;
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


    public OSResponseDTO(OS os) {

        this.id_os = os.getId_os();
        this.tipo = os.getTipo();
        this.status = os.getStatus().toString();

        this.data_Abertura = os.getData_Arbetura();
        this.data_Agendamento = os.getData_Agendamento();
        this.data_Encerramento = os.getData_Encerramento();

        this.funcionario = new FuncDTO(os.getFuncionario());
    }
}