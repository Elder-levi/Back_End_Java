package br.com.Tecmec.Aplicacao.Model.DTO.Entity;

import br.com.Tecmec.Aplicacao.Model.Equipamento;

import java.time.LocalDateTime;

public class EquipamentoDTO {

    public Long Codigo;

    public String Nome;

    public String Fabricante;

    public LocalDateTime dataAquisicao;

    public EquipamentoDTO(Equipamento e) {
        this.Codigo = e.getCodigo();
        this.Fabricante = e.getFabricante();
        this.Nome = e.getNome();
        this.dataAquisicao = e.getDataAquisicao();
    }
}
