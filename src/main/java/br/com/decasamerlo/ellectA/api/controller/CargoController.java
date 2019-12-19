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

import br.com.decasamerlo.ellectA.api.model.Cargo;
import br.com.decasamerlo.ellectA.api.repository.CargoRepository;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cargo> criar(@Valid @RequestBody Cargo cargo) {
		Cargo cargoSalvo = cargoRepository.save(cargo);
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoSalvo);
	}

}
