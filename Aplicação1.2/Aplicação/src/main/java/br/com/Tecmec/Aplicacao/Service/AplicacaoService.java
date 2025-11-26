package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryEquipamento;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryOS;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AplicacaoService {

    private final AplicacaoRepositoryEquipamento repositoryEquipamento;

    private final AplicacaoRepositoryOS repositoryOS;

    public AplicacaoService(AplicacaoRepositoryEquipamento repository, AplicacaoRepositoryOS repositoryOS) {
        this.repositoryEquipamento = repository;
        this.repositoryOS = repositoryOS;
    }

    public List<Equipamento> list() {
        return repositoryEquipamento.findAll();
    }

    public Optional<Equipamento> findById(Long id) {
         return  repositoryEquipamento.findById(id);

    }

    public Equipamento save(Equipamento equipamento) {

        return repositoryEquipamento.save(equipamento);
    }

    public OS save(OS os){
        return repositoryOS.save(os);
    }

    public boolean agendar(long Id_os, LocalDateTime dataAgendamento) {

        OS os = repositoryOS.findById(Id_os)
                .orElseThrow(() -> new IllegalArgumentException("OS não encontrada"));

        LocalDateTime limite = LocalDateTime.now().plusDays(7);

        if (dataAgendamento.isBefore(os.getData_Arbetura())) {
            throw new IllegalArgumentException("Favor abrir a Ordem de Serviço!");
        }

        if (dataAgendamento.isAfter(limite)) {
            throw new IllegalArgumentException("Só pode agendar com até 7 dias de antecedência");
        }

        os.setData_Agendamento(dataAgendamento);
        repositoryOS.save(os);
        return true;
    }



}

