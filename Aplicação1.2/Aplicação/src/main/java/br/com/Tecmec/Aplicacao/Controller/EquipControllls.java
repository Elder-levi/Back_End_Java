package br.com.Tecmec.Aplicacao.Controller;

import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTOporEquip;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Service.EquipeService;
import br.com.Tecmec.Aplicacao.Service.OSService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

   /*
    @GetMapping("/Equipamento/{id}")
    public ResponseEntity<List<DTOporEquip>> ListaPorEquip(@PathVariable Long id)
    {
        return ResponseEntity.ok(osService.listarOsPorEquipamento(id));
    }
 */
    @GetMapping("/Historico/{id}")
    public Optional<Equipamento> get(@PathVariable Long id){
        return this.equipeService.findById(id);
    }

    @PostMapping("/Cadastro")
    public Equipamento salvar(@RequestBody Equipamento equipamento) {
        return equipeService.save(equipamento);
    }







}
