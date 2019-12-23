package br.com.decasamerlo.ellectA.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Eleicao;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long> {
	
	List<Eleicao> findByDataInicioLessThanAndDataFimGreaterThan(LocalDate data1, LocalDate data2);

}
