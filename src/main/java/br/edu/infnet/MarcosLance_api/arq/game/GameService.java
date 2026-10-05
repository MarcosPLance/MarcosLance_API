package br.edu.infnet.MarcosLance_api.arq.game;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.MarcosLance_api.arq.game.dto.GameResponse;
import br.edu.infnet.MarcosLance_api.arq.trofeu.client.TrofeuGateway;
import br.edu.infnet.MarcosLance_api.arq.trofeu.client.TrofeuResponse;
import br.edu.infnet.MarcosLance_api.messaging.CadastroMessage;
import br.edu.infnet.MarcosLance_api.messaging.CadastroProducer;

@Service
public class GameService {

	private final GameRepository gameRepository;
	private final TrofeuGateway trofeuGateway;
	private final CadastroProducer cadastroProducer;
	
	public GameService(GameRepository gameRepository, TrofeuGateway trofeuGateway, CadastroProducer cadastroProducer) {
		this.gameRepository = gameRepository;
		this.trofeuGateway = trofeuGateway;
		this.cadastroProducer = cadastroProducer;
	}
	
	public GameResponse obterDetalhes(Long id) {
		Game game = obterEntidadePorId(id);
		return converterParaResponse(null);
	}
	
	
	
	private GameResponse converterParaResponse(Game game) {
		
		return new GameResponse(
				game.getID(),
				game.getNome(),
				game.getDistribuidora(),
				game.getLancamento(),
				game.getTrofeusIds());
	}
	
	
	
	
	public GameResponse incluirTrofeu(Long gameID, Long trofeuID){
		Game game = obterEntidadePorId(gameID);
		
		TrofeuResponse trofeu = trofeuGateway.obterPorId(trofeuID);
		
		if(game.getTrofeusIds().contains(trofeu.id())) {
			throw new IllegalArgumentException("Ja existe esse trofeu nesse Game");
		}
		
		game.adicionarTrofeu(trofeu.id());
		
		Game gameAtualizado = gameRepository.save(game);
		
		CadastroMessage mensagem = new CadastroMessage(gameAtualizado.getID(), trofeu.id());
		
		cadastroProducer.enviar(mensagem);
		
		return converterParaResponse(gameAtualizado);
	}
	
	//CRUD
	
	
	public GameResponse incluir(Game game) {
		Game gameIncluido = gameRepository.save(game);
		return converterParaResponse(gameIncluido);
	}
	
	
	
	public List<GameResponse> obterLista(){
		return gameRepository
                .findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
	}
	
	
	
	public GameResponse obterPorId(Long id) {
		Game game = obterEntidadePorId(id);
		return converterParaResponse(game);
	}
	
	
	
	public GameResponse alterar(Long id, Game game) {
		
		Game existente = obterEntidadePorId(id);
		
		existente.setNome(game.getNome());
		existente.setLancamento(game.getLancamento());
		existente.setDistribuidora(game.getDistribuidora());
		
		Game gameAtualizado = gameRepository.save(existente);
		
		return converterParaResponse(gameAtualizado);
	}
	
	
	
	
	public List<GameResponse> obterPorNome(String nome){
		
		 return gameRepository
	                .findByNomeContainingIgnoreCase(nome)
	                .stream()
	                .map(this::converterParaResponse)
	                .toList();
	}
	
	
	
	private Game obterEntidadePorId(Long id) {

	        return gameRepository
	                .findById(id)
	                .orElseThrow(() ->
	                        new GameNaoEncontradoException(id)
	                );
	  }
	 
	 
	
	public void excluir(Long id) {

	        Game game = obterEntidadePorId(id);

	        gameRepository.delete(game);
	} 



}
