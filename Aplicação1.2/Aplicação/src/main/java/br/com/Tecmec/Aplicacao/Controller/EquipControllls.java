package br.com.Tecmec.Aplicacao.Controller;

import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTOporEquip;
import br.com.Tecmec.Aplicacao.Model.DTO.Entity.OSResponseDTO;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Service.EquipeService;
import br.com.Tecmec.Aplicacao.Service.OSService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Equipamentos")
public class EquipControllls {


    private EquipeService equipeService;
    private OSService osService;

    public EquipControllls(EquipeService equipeService, OSService osService) {
        this.equipeService = equipeService;
        this.osService = osService;
    }

    @GetMapping("/Equipamentos")
    public List<Equipamento> getAll(){
        return equipeService.list();
    }


    @GetMapping("/Historico/Equipamento/{equipamentoId}")
    public List<DTOporEquip> historicoPorEquipamento(@PathVariable Long equipamentoId) {
        return equipeService.ListarOSporEquip(equipamentoId);
    }


    @GetMapping("/Historico/{id}")
    public Equipamento get(@PathVariable Long id){
        return this.equipeService.findById(id);
    }

    @PostMapping("/Cadastro")
    public Equipamento salvar(@Valid @RequestBody Equipamento equipamento) {
        return equipeService.save(equipamento);
    }







}
