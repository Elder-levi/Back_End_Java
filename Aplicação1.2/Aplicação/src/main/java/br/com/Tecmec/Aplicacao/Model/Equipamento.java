package br.com.Tecmec.Aplicacao.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @NotBlank
    @Column(name = "nome_equi")
    private String Nome;

    @NotBlank
    @Column(name = "fabricante")
    private String Fabricante;

    @NotNull
    @Column(name = "dataAquisicao")
    private LocalDateTime dataAquisicao;

    @JsonIgnore
    @OneToMany(mappedBy = "equipamento")
    private Set<OS> os = new HashSet<>();


    public Equipamento() {
    }

    public Equipamento(Long codigo, String nome, String fabricante) {
        this.codigo = codigo;
        this.Nome = nome;
        this.Fabricante = fabricante;
    }

    @PrePersist
    protected void onCreate() {

        if (dataAquisicao == null) {
            setDataAquisicao(LocalDateTime.now());
        }
    }

    public LocalDateTime getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDateTime dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        codigo = codigo;
    }

    public Set<OS> getOs() {
        return os;
    }

    public void setOs(Set<OS> os) {
        this.os = os;
    }
}


