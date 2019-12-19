package br.com.decasamerlo.ellectA.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
