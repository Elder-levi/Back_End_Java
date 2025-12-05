package br.com.Tecmec.Aplicacao.Model;



import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "equipamentos")
public class Equipamento {
    @Id
    @Column(name = "codigo")
    private Long Codigo;

    @Column(name = "nome_equi")
    private String Nome;

    private String Fabricante;

    @Column(name = "dataAquisicao")

    private LocalDateTime dataAquisicao;


    public Equipamento() {
    }

    public Equipamento(Long codigo, String nome, String fabricante) {
        Codigo = codigo;
        Nome = nome;
        Fabricante = fabricante;
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
        return Codigo;
    }

    public void setCodigo(Long codigo) {
        Codigo = codigo;
    }
}


