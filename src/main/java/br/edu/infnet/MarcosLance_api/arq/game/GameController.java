package br.edu.infnet.MarcosLance_api.arq.game;

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

import br.edu.infnet.MarcosLance_api.arq.game.dto.GameResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {

	private final GameService gameService;
	
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@GetMapping("{id}/detalhes")
	public ResponseEntity<GameResponse> obterDetalhes(@PathVariable Long id) {
		GameResponse gameResponse = gameService.obterDetalhes(id);
		
		return ResponseEntity.ok(gameResponse);
	}
	
	@PostMapping("/{turmaID}/trofeus/{trofeuID}")
	public ResponseEntity<GameResponse> incluirTrofeu(@PathVariable Long gameID, @PathVariable Long trofeuID){
		
		GameResponse novoTrofeu = gameService.incluirTrofeu(gameID, trofeuID);
		
		return ResponseEntity.ok(novoTrofeu);
	}
	
	
	@PostMapping
	public ResponseEntity<GameResponse> incluir(@Valid @RequestBody Game game){
		
		GameResponse gameResponse = gameService.incluir(game);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(gameResponse);
	}
	
	
	@GetMapping
	public ResponseEntity<List<GameResponse>> obterLista(){
		List<GameResponse> games = gameService.obterLista();
		return ResponseEntity.ok(games);
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<GameResponse> obterPorId(@PathVariable Long id) {

        GameResponse gameResponse = gameService.obterPorId(id);

        return ResponseEntity.ok(gameResponse);
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity <GameResponse> alterar(@PathVariable Long id,@Valid @RequestBody Game game) {
		GameResponse gameResponse = gameService.alterar(id, game);
		return ResponseEntity.ok(gameResponse);
	}
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<GameResponse>> obterPorNome(@RequestParam String nome){
		List<GameResponse> games = gameService.obterPorNome(nome);
		return ResponseEntity.ok(games);
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        gameService.excluir(id);

        return ResponseEntity.noContent().build();
    }
	
}
