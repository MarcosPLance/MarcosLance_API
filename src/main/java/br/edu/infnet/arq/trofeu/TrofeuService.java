package br.edu.infnet.arq.trofeu;

import java.util.List;

import br.edu.infnet.arq.trofeu.dto.TrofeuResponse;

public class TrofeuService  {

private final TrofeuRepository trofeuRepository;
	
	public TrofeuService(TrofeuRepository trofeuRepository) {
		this.trofeuRepository = trofeuRepository;
	}

	public TrofeuResponse incluir(Trofeu trofeu) {
		
		Trofeu trofeuIncluido = trofeuRepository.save(trofeu);

	    return converterParaResponse(trofeuIncluido);
	}
	
	public List<TrofeuResponse> obterLista(){
		return trofeuRepository.findAll()
				.stream()
                .map(this::converterParaResponse)
                .toList();
	}

	public TrofeuResponse obterPorId(Long id) {
		
		Trofeu trofeu = obterEntidadePorId(id);
		
		return converterParaResponse(trofeu);
		
	}

	public TrofeuResponse alterar(Long id, Trofeu trofeu) {

	    Trofeu existente = obterEntidadePorId(id); 
	    
	    
	    existente.setNome(trofeu.getNome());
	    existente.setTipo(trofeu.getTipo());

	    Trofeu trofeuAtualizado = trofeuRepository.save(existente);

        return converterParaResponse(trofeuAtualizado);
	}

	public void excluir(Long id) {
		
		Trofeu existente = obterEntidadePorId(id);
		
		trofeuRepository.delete(existente);
	}

//	public List<Trofeu> obterOuro(){
//		return trofeuRepository.findByTipo();
//	}

	public List<TrofeuResponse> obterPorNome(String nome){
		return trofeuRepository
                .findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::converterParaResponse)
                .toList();
	}

	public Trofeu obterEntidadePorId(Long id){
		return trofeuRepository.findById(id).orElseThrow(() -> new TrofeuNaoEncontradoException(id));
	}
	
	private TrofeuResponse converterParaResponse(Trofeu trofeu) {

        return new TrofeuResponse(
                trofeu.getID(),
                trofeu.getNome(),
                trofeu.getTipo()
        );
    }
	
}
