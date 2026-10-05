package br.edu.infnet.arq.trofeu;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.arq.trofeu.dto.TrofeuResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/trofeu")
public class trofeuController {

	private final TrofeuService trofeuService;

	public trofeuController(TrofeuService trofeuService) {
		this.trofeuService = trofeuService;
	}
	
	
	
	@PostMapping
    public ResponseEntity<TrofeuResponse> incluir(@Valid @RequestBody Trofeu trofeu) {

		TrofeuResponse trofeuResponse = trofeuService.incluir(trofeu);
		
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trofeuResponse);
    }

	
	
    @GetMapping
    public ResponseEntity<List<TrofeuResponse>> obterLista() {

        return ResponseEntity.ok(
                trofeuService.obterLista()
        );
    }

    
    
    @GetMapping("/{id}")
    public ResponseEntity<TrofeuResponse> obterPorId(@PathVariable Long id) {

        return ResponseEntity.ok(
                trofeuService.obterPorId(id)
        );
    }

    
    
    @PutMapping("/{id}")
    public ResponseEntity<TrofeuResponse> alterar(@PathVariable Long id, @Valid @RequestBody Trofeu trofeu) {

        return ResponseEntity.ok(
                trofeuService.alterar(id, trofeu)
        );
    }

    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        trofeuService.excluir(id);

        return ResponseEntity.noContent().build();
    }



    @GetMapping("/buscar")
    public ResponseEntity<List<TrofeuResponse>> obterPorNome(@RequestParam String nome) {

        return ResponseEntity.ok(
                trofeuService.obterPorNome(nome)
        );
    }


	
	
}
