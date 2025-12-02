package br.com.Tecmec.Aplicacao.Controller;

import br.com.Tecmec.Aplicacao.Model.DTO.AgendamentoDTO;
import br.com.Tecmec.Aplicacao.Model.DTO.OSDto;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Service.EquipeService;
import br.com.Tecmec.Aplicacao.Service.FuncService;
import br.com.Tecmec.Aplicacao.Service.OSService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/OS")
public class OSControlls {

    private final OSService osService;
    private final FuncService funcService;
    private final EquipeService equipeService;

    public OSControlls(OSService osService, FuncService funcService, EquipeService equipeService) {
        this.osService = osService;
        this.funcService = funcService;
        this.equipeService = equipeService;
    }

    @PostMapping("/Criar")
    public ResponseEntity<?> Criar(@RequestBody OSDto dto){
        Funcionario funcionario = funcService.findById(dto.funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Equipamento equipamento = equipeService.findById(dto.equipamnetoId)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        OS os = new OS(dto.tipo);
        os.setFuncionario(funcionario);
        os.setEquipamento(equipamento);

        osService.save(os);

        return ResponseEntity.ok("Ordem de Serviço Criada com sucesso");

    }

    @PostMapping("/Agendamento/Manutencao/{id}")
    public ResponseEntity<?> agendar(
            @PathVariable("id") long idOs,
            @RequestBody AgendamentoDTO otd
            ) {
        this.osService.agendar(idOs, otd.dataAgendamento);
        return ResponseEntity.ok("Agendado com sucesso!");
    }



}
