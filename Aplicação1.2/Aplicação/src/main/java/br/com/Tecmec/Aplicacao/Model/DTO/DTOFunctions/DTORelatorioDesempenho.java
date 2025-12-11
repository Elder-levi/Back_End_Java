package br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions;

import java.util.Map;

public class DTORelatorioDesempenho {


    private long totalOs;
    private long abertas;
    private long encerradas;
    private long emAndamento;

    private Map<String, Long> osPorFuncionario;
    private Map<String, Long> osPorEquipamento;
    private Map<String, Long> osPorTipo;


    public long getTotalOs() {
        return totalOs;
    }

    public void setTotalOs(long totalOs) {
        this.totalOs = totalOs;
    }

    public long getAbertas() {
        return abertas;
    }

    public void setAbertas(long abertas) {
        this.abertas = abertas;
    }

    public long getEncerradas() {
        return encerradas;
    }

    public void setEncerradas(long encerradas) {
        this.encerradas = encerradas;
    }

    public long getEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(long emAndamento) {
        this.emAndamento = emAndamento;
    }

    public Map<String, Long> getOsPorFuncionario() {
        return osPorFuncionario;
    }

    public void setOsPorFuncionario(Map<String, Long> osPorFuncionario) {
        this.osPorFuncionario = osPorFuncionario;
    }

    public Map<String, Long> getOsPorTipo() {
        return osPorTipo;
    }

    public void setOsPorTipo(Map<String, Long> osPorTipo) {
        this.osPorTipo = osPorTipo;
    }

    public Map<String, Long> getOsPorEquipamento() {
        return osPorEquipamento;
    }

    public void setOsPorEquipamento(Map<String, Long> osPorEquipamento) {
        this.osPorEquipamento = osPorEquipamento;
    }
}
