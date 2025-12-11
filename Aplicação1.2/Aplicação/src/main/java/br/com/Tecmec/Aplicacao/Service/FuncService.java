package br.com.Tecmec.Aplicacao.Service;

import br.com.Tecmec.Aplicacao.Exception.ResourceNotFoundException;
import br.com.Tecmec.Aplicacao.Model.Funcionario;
import br.com.Tecmec.Aplicacao.Repository.AplicacaoRepositoryFuncionario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncService {

    private final AplicacaoRepositoryFuncionario FuncResposity;

    public FuncService(AplicacaoRepositoryFuncionario funcResposity) {
        FuncResposity = funcResposity;
    }

    public List<Funcionario> GetAll()
    {
        return FuncResposity.findAll();
    }

    public Funcionario findById( Long id)
    {
        return FuncResposity.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Funcionário não encontrado."
        ));

    }






}

