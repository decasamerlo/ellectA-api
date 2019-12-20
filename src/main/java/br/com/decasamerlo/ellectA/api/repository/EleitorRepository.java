package br.com.decasamerlo.ellectA.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.decasamerlo.ellectA.api.model.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {

	public Optional<Eleitor> findByCpfAndNome(String cpf, String nome);
	
}
