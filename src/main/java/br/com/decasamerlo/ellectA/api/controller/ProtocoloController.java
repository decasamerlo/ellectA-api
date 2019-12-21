package br.com.decasamerlo.ellectA.api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.decasamerlo.ellectA.api.model.Eleitor;
import br.com.decasamerlo.ellectA.api.model.Protocolo;
import br.com.decasamerlo.ellectA.api.repository.ProtocoloRepository;
import br.com.decasamerlo.ellectA.api.service.ProtocoloService;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

	@Autowired
	private ProtocoloRepository protocoloRepository;

	@Autowired
	private ProtocoloService protocoloService;

	@GetMapping
	public ResponseEntity<Protocolo> buscar(@RequestParam(required=true) Long eleitor, @RequestParam(required=true) Long eleicao) {
		Optional<Protocolo> protocolo = protocoloRepository.findByEleicaoIdAndEleitorId(eleitor, eleicao);
		return protocolo.isPresent() ? ResponseEntity.ok(protocolo.get()) : ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Protocolo> criar(@Valid @RequestBody Protocolo protocolo) {
		Protocolo protocoloSalvo = protocoloService.salvar(protocolo);
		return ResponseEntity.status(HttpStatus.CREATED).body(protocoloSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Protocolo> buscarPeloId(@PathVariable Long id) {
		Optional<Protocolo> protocolo = protocoloRepository.findById(id);
		return protocolo.isPresent() ? ResponseEntity.ok(protocolo.get()) : ResponseEntity.notFound().build();
	}

}
