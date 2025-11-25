package br.com.Tecmec.Aplicacao.Controller;


import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Service.AplicacaoService;
import org.springframework.web.bind.annotation.*;

;
import java.util.List;
import java.util.Optional;

@RestController
public class aplicacaoController {
    private AplicacaoService AplicacaoService;

    public aplicacaoController(AplicacaoService aplicacaoService) {
        this.AplicacaoService = aplicacaoService;
    }

    @GetMapping("/Equipamentos")
    public List<Equipamento> getAll(){
        return AplicacaoService.list();
    }

    @GetMapping("/Historico/{id}")
    public Optional<Equipamento> get(@PathVariable Long id){
        return this.AplicacaoService.findById(id);
    }

    @PostMapping("/Cadastro")
    public Equipamento salvar(@RequestBody Equipamento equipamento) {
        return AplicacaoService.save(equipamento);
    }

    @PostMapping("/OS")
    public OS AberturaOs(@RequestParam Equipamento equipamento, @RequestParam Funcionario funcionario, @RequestBody OS os){
        return AplicacaoService.save(os);
    }







}
