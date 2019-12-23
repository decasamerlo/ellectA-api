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

import br.com.decasamerlo.ellectA.api.model.Voto;
import br.com.decasamerlo.ellectA.api.repository.VotoRepository;

@RestController
@RequestMapping("/votos")
public class VotoController {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@GetMapping
	public List<Voto> listar() {
		return votoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Voto> criar(@Valid @RequestBody Voto voto) {
		Voto votoSalvo = votoRepository.save(voto);
		return ResponseEntity.status(HttpStatus.CREATED).body(votoSalvo);
	}

}
