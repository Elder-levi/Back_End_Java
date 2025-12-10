package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTORelatorioDesenpenho;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.OSDto;
import br.com.Tecmec.Aplicacao.Model.DTO.Entity.OSResponseDTO;
import br.com.Tecmec.Aplicacao.Model.Enums.Status;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryOS;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OSService {

    private final AplicacaoRepositoryOS repositoryOS;

    public OSService(AplicacaoRepositoryOS repositoryOS) {
        this.repositoryOS = repositoryOS;
    }


    public List<OS> GetAll()
    {
        return repositoryOS.findAll();
    }


    public Optional<OS> FindByID(Long id){return repositoryOS.findById(id);}

    public OS save(OS os){
        return repositoryOS.save(os);
    }


    public DTORelatorioDesenpenho gerarRelatorio()
    {
        DTORelatorioDesenpenho dto = new DTORelatorioDesenpenho();

        dto.setTotalOs(repositoryOS.count());
        dto.setAbertas(repositoryOS.countByStatus(Status.ABERTO));
        dto.setAbertas(repositoryOS.countByStatus(Status.EM_ANDAMENTO));
        dto.setAbertas(repositoryOS.countByStatus(Status.ENCERRADO));

        return dto;
    }



@PutMapping("/Editar/{id}")
public ResponseEntity<?> editar(@RequestBody OSDto dto, @PathVariable long id){
    OS atualizado = osService.editar(id, dto);
    return ResponseEntity.ok(new OSResponseDTO(atualizado));
}





        
    }

    
public Os Criar(OSDto dto)
{
 Funcionario funcionario = funcService.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Equipamento equipamento = equipeService.findById(dto.getEquipamnetoId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        OS os = new OS(dto.getTipo());
        os.setFuncionario(funcionario);
        os.setEquipamento(equipamento);

       return repositoryOS.save(os);
}


    public boolean agendar(long Id_os, LocalDateTime dataAgendamento) {

        OS os = repositoryOS.findById(Id_os)
                .orElseThrow(() -> new IllegalArgumentException("OS não encontrada"));

        LocalDateTime minimo = LocalDateTime.now().plusDays(7);

        if (dataAgendamento.isAfter(minimo)) {
            throw new IllegalArgumentException("Só pode agendar com até 7 dias de antecedência");
        }
        if (dataAgendamento.isBefore(os.getData_Arbetura())) {
            throw new IllegalArgumentException("Favor abrir a Ordem de Serviço!");
        }
        os.setData_Agendamento(dataAgendamento);
        return repositoryOS.save(os);
    }

}
