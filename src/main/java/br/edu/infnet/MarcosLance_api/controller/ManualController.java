package br.edu.infnet.MarcosLance_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.MarcosLance_api.domain.Manual;
import br.edu.infnet.MarcosLance_api.exception.RecursoNaoEncontradoException;
import br.edu.infnet.MarcosLance_api.service.ManualService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manuais")
public class ManualController {

	private final ManualService manualService;

	public ManualController(ManualService manualService) {
		this.manualService = manualService;
		
		List <Manual> manual = this.manualService.obterLista();
	}
	
	@GetMapping
	public List<Manual> obterListaManuais(){
		return manualService.obterLista();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Manual> obterPorId(@PathVariable Long id) {
		
		try {
			Manual manual = manualService.obterPorID(id);
			return ResponseEntity.ok(manual);
		}catch(RecursoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
		//return manualService.obterPorId(id);
	}
	
	@GetMapping(params = "titulo")
	public ResponseEntity<List<Manual>> obterPorTitulo(@RequestParam String titulo) {
		
		List<Manual> manuais = manualService.buscaPorTitulo(titulo);
		return ResponseEntity.ok(manuais);
		
	}
	
	@PostMapping
	public ResponseEntity<Manual> incluir(@Valid @RequestBody Manual manual) {

		manualService.incluir(manual);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(manual.getID()).toUri();
		
		//return ResponseEntity.status(HttpStatus.CREATED).body(manual);
		return ResponseEntity.created(location).body(manual);
	}

	@GetMapping("/perdiveis")
	public ResponseEntity<List<Manual>> obterPerdiveis(){
		List<Manual> manuais  = manualService.obterPublicados();
		
		return ResponseEntity.ok(manuais);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Manual> alterar(@PathVariable Long id,@Valid @RequestBody Manual manual){
		
		
		manual.setID(id);
		
		manualService.alterar(id, manual);
		
		return ResponseEntity.ok(manual);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		
		manualService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
