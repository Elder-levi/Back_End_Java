package br.com.Tecmec.Aplicacao.Repository;
import br.com.Tecmec.Aplicacao.Model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface AplicacaoRepositoryEquipamento extends JpaRepository<Equipamento, Long> {}


