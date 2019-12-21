package br.com.decasamerlo.ellectA.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Protocolo;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {

	Optional<Protocolo> findByEleicaoIdAndEleitorId(Long eleitor, Long eleicao);

}
