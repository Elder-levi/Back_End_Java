package br.com.Tecmec.Aplicacao.Controller;

import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Service.OSService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class OSControlls {

    private final OSService osService;

    public OSControlls(OSService osService) {
        this.osService = osService;
    }


    @PostMapping("/OS")
    public OS AberturaOs(@RequestParam Equipamento equipamento, @RequestParam Funcionario funcionario, @RequestBody OS os){
        return osService.save(os);
    }

    @PostMapping("/Agendamento/Manutencao/{id_os}")
    public ResponseEntity<?> agendar(
            @PathVariable("id_os") long idOs,
            @RequestBody
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime dataAgendamento
    ) {
        this.osService.agendar(idOs, dataAgendamento);
        return ResponseEntity.ok("Agendado com sucesso!");
    }



}
