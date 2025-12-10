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


 public OS encerrarOS(long id) {
        OS os = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OS não encontrada"));

        if (os.getStatus() == Status.ENCERRADO) {
            throw new IllegalStateException("OS já está encerrada.");
        }

        os.setStatus(Status.ENCERRADO);

        os.setDataEncerramento(java.time.LocalDateTime.now());

        return repository.save(os);
    }

    
    
public OS editar(long id, OSDto dto) {

    OS os = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("OS não encontrada"));

    if (os.getStatus() == Status.ENCERRADO) {
        throw new IllegalArgumentException("Não é possível editar uma OS encerrada.");
    }

    Funcionario funcionario = funcService.findById(dto.getFuncionarioId())
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

    Equipamento equipamento = equipeService.findById(dto.getEquipamnetoId())
            .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

    os.setFuncionario(funcionario);
    os.setEquipamento(equipamento);
    os.setDataAgendamento(dto.getDataAgendamento());
    os.setTipo(dto.getTipo());
    os.setStatus(Status.EM_ANDAMENTO);

    return repository.save(os);
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



}
