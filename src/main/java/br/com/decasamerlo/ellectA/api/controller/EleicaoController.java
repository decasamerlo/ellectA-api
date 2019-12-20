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

import br.com.decasamerlo.ellectA.api.model.Eleicao;
import br.com.decasamerlo.ellectA.api.repository.EleicaoRepository;

@RestController
@RequestMapping("/eleicoes")
public class EleicaoController {
	
	@Autowired
	private EleicaoRepository eleicaoRepository;
	
	@GetMapping
	public List<Eleicao> listar() {
		return eleicaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Eleicao> criar(@Valid @RequestBody Eleicao eleicao) {
		Eleicao eleicaoSalva = eleicaoRepository.save(eleicao);
		return ResponseEntity.status(HttpStatus.CREATED).body(eleicaoSalva);
	}

}
