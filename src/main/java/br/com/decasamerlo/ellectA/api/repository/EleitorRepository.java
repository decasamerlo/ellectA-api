package br.com.decasamerlo.ellectA.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {

}
