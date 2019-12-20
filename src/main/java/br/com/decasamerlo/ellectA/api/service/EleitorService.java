package br.com.decasamerlo.ellectA.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.decasamerlo.ellectA.api.model.Eleitor;
import br.com.decasamerlo.ellectA.api.repository.EleitorRepository;

@Service
public class EleitorService {
	
	@Autowired
	private EleitorRepository eleitorRepository;
	
	public Eleitor salvar(Eleitor eleitor) {
		Optional<Eleitor> eleitorBd = eleitorRepository.findByCpfAndNome(eleitor.getCpf(), eleitor.getNome());
		
		if (eleitorBd.isPresent()) {
			return eleitorBd.get();
		}
		
		return eleitorRepository.save(eleitor);
	}

}
