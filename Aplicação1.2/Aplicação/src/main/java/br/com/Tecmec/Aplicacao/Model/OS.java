package br.com.Tecmec.Aplicacao.Model;

import br.com.Tecmec.Aplicacao.Model.Enums.Status;
import br.com.Tecmec.Aplicacao.Model.Enums.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_servicos")
public class OS  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_os;

    @Column(name = "tipo")
    @Enumerated( EnumType.STRING )
    private Tipo tipo;

    @Enumerated( EnumType.STRING )
    private Status status;

    @Column(name = "dataAbertura")
    private LocalDateTime dataAbertura;

    @Column(name = "dataAgendamento")
    private LocalDateTime dataAgendamento;

    @Column(name = "dataEncerramento")
    private LocalDateTime dataEncerramento;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    public OS() {}

    public OS(Tipo tipo) {
        this.tipo = tipo;
        this.status = Status.ABERTA;
    }
    @PrePersist
    protected void onCreate() {

        if (dataAbertura == null) {
            setDataAbertura(LocalDateTime.now());
        }
    }

    public long getId_os() {
        return Id_os;
    }

    public void setId_os(long id_os) {
        Id_os = id_os;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
