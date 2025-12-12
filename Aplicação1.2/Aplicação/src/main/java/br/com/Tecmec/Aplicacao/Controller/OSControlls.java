package br.com.Tecmec.Aplicacao.Controller;

import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTONotificação;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTORelatorioDesempenho;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTOporEquip;
import br.com.Tecmec.Aplicacao.Model.DTO.Entity.OSResponseDTO;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.OSDto;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Service.EquipeService;
import br.com.Tecmec.Aplicacao.Service.FuncService;
import br.com.Tecmec.Aplicacao.Service.OSService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OS")
public class OSControlls {

    private final OSService osService ;
    private final FuncService funcService;
    private final EquipeService equipeService;




    public OSControlls(OSService osService, FuncService funcService, EquipeService equipeService) {
        this.osService = osService;
        this.funcService = funcService;
        this.equipeService = equipeService;
    }

    @GetMapping("/Notificacoes")
    public ResponseEntity<List<DTONotificação>> notificacoesAgendamentos() {
        return ResponseEntity.ok(osService.listarAgendamentosProximos());
    }


    @GetMapping("/Historico/Manutencoees")
    public List<OSResponseDTO> GetALl()
    {
        return osService.GetAll()
                        .stream()
                        .map( OSResponseDTO ::new)
                        .toList();
        // NESSA ROTA EU USEI O STEAM NO MEU METODOS GETALL QUE ME RETORNA UMA LISTA DO BANCO
        // DO TIPO "OS" POREM EU TRANSFORMO ESSA LISTA PRO TIPO "OSResponseDTO"
    }

    @PutMapping("/os/{idOs}/encerrar/{idFuncionario}")
    public ResponseEntity<?> encerrar(
            @PathVariable Long idOs,
            @PathVariable Long idFuncionario
    ) {
        osService.encerrarOS(idOs, idFuncionario);
        return ResponseEntity.ok("OS encerrada com sucesso.");
    }


@PostMapping("/Criar")
public ResponseEntity<?> criar(@RequestBody OSDto dto){
    osService.Criar(dto);
    return ResponseEntity.ok("Ordem de Serviço criada com sucesso");
}

  @PutMapping("/Editar/{id}")
   public ResponseEntity<?> editar(@RequestBody OSDto dto, @PathVariable long id){
    OS atualizado = osService.editar(id, dto);
    return ResponseEntity.ok(new OSResponseDTO(atualizado));
  }




    @GetMapping("/Relatorio/Desempenho")
    public DTORelatorioDesempenho Relatorio()
   {
       return  osService.gerarRelatorio();
   }


   @DeleteMapping("/Deletar/{id}")
   public ResponseEntity<?> Delete(@PathVariable Long id)
   {
       osService.Deletar(id);
       return  ResponseEntity.ok("Deletado......");
   }



}
