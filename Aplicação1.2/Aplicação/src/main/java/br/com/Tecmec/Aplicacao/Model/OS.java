package br.com.Tecmec.Aplicacao.Model;

import br.com.Tecmec.Aplicacao.Model.Enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "Registro_Servicos")
public class OS  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_os;

    @Column(name = "tipo")
    private String tipo;

    @Enumerated( EnumType.STRING )
    private Status status;

    @Column(name = "dataAbertura")
    private LocalDateTime Data_Arbetura;

    @Column(name = "dataAgendamento")
    private LocalDateTime data_Agendamento;

    @Column(name = "dataEncerramento")
    private LocalDateTime data_Encerramento;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    public OS() {}

    public OS(String tipo) {
        this.tipo = tipo;
        this.status = Status.ABERTO;
    }
    @PrePersist
    protected void onCreate() {

        if (Data_Arbetura == null) {
            setData_Arbetura(LocalDateTime.now());
        }
    }

    public long getId_os() {
        return Id_os;
    }

    public void setId_os(long id_os) {
        Id_os = id_os;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getData_Arbetura() {
        return Data_Arbetura;
    }

    public void setData_Arbetura(LocalDateTime data_Arbetura) {
        Data_Arbetura = data_Arbetura;
    }

    public LocalDateTime getData_Agendamento() {
        return data_Agendamento;
    }

    public void setData_Agendamento(LocalDateTime data_Agendamento) {
        this.data_Agendamento = data_Agendamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getData_Encerramento() {
        return data_Encerramento;
    }

    public void setData_Encerramento(LocalDateTime data_Encerramento) {
        this.data_Encerramento = data_Encerramento;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
