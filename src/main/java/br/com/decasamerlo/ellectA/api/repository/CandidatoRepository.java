package br.com.decasamerlo.ellectA.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
