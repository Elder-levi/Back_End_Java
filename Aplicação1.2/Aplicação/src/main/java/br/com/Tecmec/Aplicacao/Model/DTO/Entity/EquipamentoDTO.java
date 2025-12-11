package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.Equipamento;

import java.time.LocalDate;

public class EquipamentoDTO {

    private Long Codigo;

    private String Nome;

    private String Fabricante;

    private LocalDate dataAquisicao;

    public EquipamentoDTO(Equipamento e) {
        this.Codigo = e.getCodigo();
        this.Fabricante = e.getFabricante();
        this.Nome = e.getNome();
        this.dataAquisicao = e.getDataAquisicao();
    }

    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long codigo) {
        Codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
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
}
