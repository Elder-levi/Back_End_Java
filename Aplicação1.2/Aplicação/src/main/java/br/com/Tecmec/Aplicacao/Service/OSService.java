package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Exception.BadRequestException;
import br.com.Tecmec.Aplicacao.Exception.ResourceNotFoundException;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTORelatorioDesempenho;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.EncerrarOSDTO;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.OSDto;
import br.com.Tecmec.Aplicacao.Model.Enums.Status;
import br.com.Tecmec.Aplicacao.Model.Enums.Tipo;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryEquipamento;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryFuncionario;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryOS;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OSService {

    private final AplicacaoRepositoryOS repositoryOS;

    private final AplicacaoRepositoryFuncionario FuncResposity;

    private final AplicacaoRepositoryEquipamento repositoryEquipamento;

    public OSService(AplicacaoRepositoryOS repositoryOS, AplicacaoRepositoryFuncionario funcResposity, AplicacaoRepositoryEquipamento repositoryEquipamento) {
        this.repositoryOS = repositoryOS;
        this.FuncResposity = funcResposity;
        this.repositoryEquipamento = repositoryEquipamento;
    }

    public List<OS> GetAll()
    {
        return repositoryOS.findAll();
    }


    public OS FindByID(Long id){
        return repositoryOS.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Ordem de serviço, não encontrada."
        ));}

    public OS save(OS os){
        return repositoryOS.save(os);
    }


    public DTORelatorioDesempenho gerarRelatorio()
    {
        DTORelatorioDesempenho dto = new DTORelatorioDesempenho();

        dto.setTotalOs(repositoryOS.count());
        dto.setAbertas(repositoryOS.countByStatus(Status.ABERTA));
        dto.setEmAndamento(repositoryOS.countByStatus(Status.EM_ANDAMENTO));
        dto.setEncerradas(repositoryOS.countByStatus(Status.ENCERRADA));

        Map<String, Long> porEquip = repositoryOS.totalPorEquipamneto().stream().collect(Collectors.toMap(
                r -> (String) r[0],
                 r -> (Long) r[1]
        ));

      Map<String, Long> porFunc = repositoryOS.totalPorFuncionario().stream().collect(Collectors.toMap(
                f -> (String) f[0],
                f -> (Long) f[1]
        ));



        Map<Enum, Long> Tipo = repositoryOS.totalPorTipo().stream().collect(Collectors.toMap(
                t -> (Enum) t[0],
                t -> (Long) t[1]
        ));


        dto.setOsPorFuncionario(porFunc);
        dto.setOsPorEquipamento(porEquip);
        dto.setOsPorTipo(Tipo);
        return dto;
    }

    public void Deletar(Long id)
    {
        repositoryOS.deleteById(id);
    }


 public EncerrarOSDTO encerrarOS(EncerrarOSDTO E){
        OS os = repositoryOS.findById(E.getId())
                .orElseThrow(() -> new ResourceNotFoundException("OS não encontrada"));

        if (os.getStatus() == Status.ENCERRADA) {
            throw new IllegalStateException("OS já está encerrada.");
        }

        if (os.getTipo().equals(Tipo.CORRETIVA)){
            if (E.getFuncionarioId() == os.getFuncionario().getId()) {
                os.setStatus(Status.ENCERRADA);
                os.setDataEncerramento(LocalDateTime.now());
            }
            else {
                throw new BadRequestException("Apenas o técnico responsavel" +
                        "pela ordem de serviço pode apaga-la," +
                        "Id do funcionario reponsavel: " + os.getFuncionario().getId());
            }
        }
        repositoryOS.save(os);
        return E;


 }

    
    
public OS editar(long id, OSDto dto) {

    OS os = repositoryOS.findById(id)
            .orElseThrow(() -> new RuntimeException("OS não encontrada"));

    if (os.getStatus() == Status.ENCERRADA) {
        throw new IllegalArgumentException("Não é possível editar uma OS encerrada.");
    }

    Funcionario funcionario =  FuncResposity.findById(dto.getFuncionarioId())
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

    Equipamento equipamento = repositoryEquipamento.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

    os.setFuncionario(funcionario);
    os.setEquipamento(equipamento);
    os.setDataAgendamento(dto.getDataAgendamento());
    os.setTipo(dto.getTipo());
    os.setStatus(Status.EM_ANDAMENTO);

    return repositoryOS.save(os);
}


    
public OS Criar(OSDto dto){
        Funcionario funcionario = FuncResposity.findById(dto.getFuncionarioId())
                .orElseThrow(()-> new ResourceNotFoundException(
                "Funcionário não encontrado."
        ));

        Equipamento equipamento = repositoryEquipamento.findById(dto.getEquipamentoId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Equipamento não encontrado"));

        OS os = new OS(dto.getTipo());
        os.setFuncionario(funcionario);
        os.setEquipamento(equipamento);

    LocalDateTime minimo = LocalDateTime.now().plusDays(7);
    if(dto.getDataAgendamento().isBefore(minimo)) {
        throw new BadRequestException("A data de agendamento deve ter no mínimo 7 dias de antecedência.");
    }
    os.setDataAgendamento(dto.getDataAgendamento());



       return repositoryOS.save(os);
}

    /*public List<DTOporEquip> listarOsPorEquipamento(Long equipamentoId) {

        List<OS> lista = repositoryOS.findByEquipamento_Codigo(equipamentoId);

        return lista.stream()
                .map(os -> new DTOporEquip(
                        os.getTipo(),                         // 1º parâmetro: Tipo
                        os.getId_os(),                        // 2º parâmetro: Código da OS
                        os.getStatus().name(),                // 3º parâmetro: Status
                        os.getData_Arbetura(),                // 4º: data abertura
                        os.getData_Agendamento(),             // 5º: data agendamento
                        os.getData_Encerramento(),            // 6º: data encerramento
                        os.getFuncionario() != null ?         // 7º: nome do funcionário
                                os.getFuncionario().getNome() : null
                ))
                .toList();
    }
    */





}
