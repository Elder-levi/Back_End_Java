package br.com.Tecmec.Aplicacao.Model;



import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "equipamentos")
@Data
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


}


