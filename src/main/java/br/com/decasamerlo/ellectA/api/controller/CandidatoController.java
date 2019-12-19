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

import br.com.decasamerlo.ellectA.api.model.Candidato;
import br.com.decasamerlo.ellectA.api.repository.CandidatoRepository;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@GetMapping
	public List<Candidato> listar() {
		return candidatoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Candidato> criar(@Valid @RequestBody Candidato candidato) {
		Candidato candidatoSalvo = candidatoRepository.save(candidato);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidatoSalvo);
	}

}
