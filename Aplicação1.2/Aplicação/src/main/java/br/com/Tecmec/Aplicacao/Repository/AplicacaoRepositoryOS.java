package br.com.Tecmec.Aplicacao.Repository;

import br.com.Tecmec.Aplicacao.Model.DTO.DTOFunctions.DTOporEquip;
import br.com.Tecmec.Aplicacao.Model.Enums.Status;
import br.com.Tecmec.Aplicacao.Model.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AplicacaoRepositoryOS extends JpaRepository<OS, Long> {

    long countByStatus(Status status);


    @Query("SELECT f.nome , COUNT(o) FROM OS o JOIN o.funcionario f GROUP BY f.nome")
    List<Object[]> totalPorFuncionario();

    @Query("SELECT e.Nome , COUNT(o) FROM OS o JOIN o.equipamento e GROUP BY e.Nome")
    List<Object[]> totalPorEquipamneto();

    @Query("SELECT o.tipo, COUNT(o) FROM OS o GROUP BY o.tipo")
    List<Object[]> totalPorTipo();

    @Query("SELECT o FROM OS o WHERE o.dataAgendamento IS NOT NULL AND o.dataAgendamento > CURRENT_TIMESTAMP")
    List<OS> findAgendamentosFuturos();

    List<OS> findByEquipamento_Codigo(Long codigo);

 }
