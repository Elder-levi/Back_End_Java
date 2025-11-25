package br.com.Tecmec.Aplicacao.Repository;

import br.com.Tecmec.Aplicacao.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacaoRepositoryFuncionario extends JpaRepository<Funcionario, Long> {
}
