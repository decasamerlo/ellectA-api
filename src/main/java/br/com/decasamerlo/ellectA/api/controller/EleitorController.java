package br.com.decasamerlo.ellectA.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.decasamerlo.ellectA.api.model.Eleitor;
import br.com.decasamerlo.ellectA.api.repository.EleitorRepository;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {
	
	@Autowired
	private EleitorRepository eleitorRepository;
	
	@GetMapping
	public List<Eleitor> listar() {
		return eleitorRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Eleitor> criar(@Valid @RequestBody Eleitor eleitor) {
		Eleitor eleitorSalvo = eleitorRepository.save(eleitor);
		return ResponseEntity.status(HttpStatus.CREATED).body(eleitorSalvo);
	}

}
