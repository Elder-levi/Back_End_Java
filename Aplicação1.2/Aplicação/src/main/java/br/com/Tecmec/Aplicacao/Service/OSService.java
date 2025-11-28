package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryOS;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OSService {

    private final AplicacaoRepositoryOS repositoryOS;

    public OSService(AplicacaoRepositoryOS repositoryOS) {
        this.repositoryOS = repositoryOS;
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
