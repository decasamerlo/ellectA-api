package br.com.decasamerlo.ellectA.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	
	List<Voto> findByProtocoloEleicaoId(Long idEleicao);
	
}
