package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Exception.ResourceNotFoundException;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryEquipamento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    private final AplicacaoRepositoryEquipamento repositoryEquipamento;



    public EquipeService(AplicacaoRepositoryEquipamento repository) {
        this.repositoryEquipamento = repository;
    }

    public List<Equipamento> list() {
        return repositoryEquipamento.findAll();
    }

    public Equipamento findById(Long id) {
         return  repositoryEquipamento.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                 "Equipamento não encontrado."
         ));

    }

    public Equipamento save(Equipamento equipamento) {

        return repositoryEquipamento.save(equipamento);
    }









}

