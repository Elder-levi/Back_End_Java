package br.com.Tecmec.Aplicacao.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "Registro_Servicos")
@Data
public class OS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_os;

    private String tipo;
    private String Status;

    private LocalDateTime data_Arbetura;
    private LocalDateTime data_Agendamento;
    private LocalDateTime data_Encerramento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    public OS() {}

    public OS(String tipo, String status) {
        this.tipo = tipo;
        this.Status =status;


    }
    @PrePersist
    protected void onCreate() {

        if (data_Arbetura == null) {
            setData_Arbetura(LocalDateTime.now());
        }
    }
}
