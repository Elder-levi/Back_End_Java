package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Exception.ResourceNotFoundException;
import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTOporEquip;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Model.OS;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryEquipamento;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryOS;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    private final AplicacaoRepositoryEquipamento repositoryEquipamento;

   private final AplicacaoRepositoryOS repositoryOS;

    public EquipeService(AplicacaoRepositoryEquipamento repositoryEquipamento, AplicacaoRepositoryOS repositoryOS) {
        this.repositoryEquipamento = repositoryEquipamento;
        this.repositoryOS = repositoryOS;
    }

    public List<Equipamento> list() {
        return repositoryEquipamento.findAll();
    }

    public Equipamento findById(Long id) {
         return  repositoryEquipamento.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                 "Equipamento não encontrado."
         ));

    }


    public List<DTOporEquip> ListarOSporEquip(Long id)
    {

        List<OS> lista = repositoryOS.findByEquipamento_Codigo(id);

        return  lista.stream().map( os -> new DTOporEquip(
                os.getId_os(),
                os.getTipo(),
                os.getStatus().name(),
                os.getDataAbertura(),
                os.getDataAgendamento(),
                os.getDataEncerramento(),
                os.getFuncionario() != null ? os.getFuncionario().getNome() : null

        )).toList();
    }

    public Equipamento save(Equipamento equipamento) {

        return repositoryEquipamento.save(equipamento);
    }









}

