package br.edu.infnet.MarcosLance_api.arq.manual;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.MarcosLance_api.arq.game.Game;
import br.edu.infnet.MarcosLance_api.exception.RecursoNaoEncontradoException;
import br.edu.infnet.MarcosLance_api.service.BaseService;

@Service
public class ManualService extends BaseService<Manual> {

	private final ManualRepository manualRepository;
	
 	public List<Manual> obterPublicados(){
		List<Manual> publicados = new ArrayList<Manual>();
		
		
		for (Manual manual : obterLista()) {
			if(manual.isPublicado()) {
				publicados.add(manual);
			}
		}
		return publicados;
	}

	public List<Manual> obterListaPublicados(){
		return obterLista().stream().filter(Manual::isPublicado).toList();
	}

	public List<Manual> obterPublicadosDeclarativos(){
		return obterLista()
				.stream()
				.filter(Manual::isPerdivel)
				.toList();
	}

		
	public List<Manual> buscaPorTitulo(String termo){
		
		List<Manual> resultado = new ArrayList<Manual>();
		
		for(Manual manual : obterLista()) {
			
			if(manual.getDescricao().toLowerCase().contains(termo.toLowerCase())) {
				resultado.add(manual);
			}
		}
		
		return resultado;
	}

	public ManualService(ManualRepository manualRepository) {
		this.manualRepository = manualRepository;
	}
	
	public List<Manual> obterLista(){
		return manualRepository.findAll();
	}
	
	public void incluir(Manual manual) {
		manualRepository.save(manual);
	}

	public Manual obterPorID(Long id) {
		return manualRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum Manual encontrado"));
	}
	
	public void alterar(Long id, Manual manual) {
		Manual existente = obterPorID(id);
		
		existente.setTitulo(manual.getTitulo());
		existente.setDescricao(manual.getDescricao());
		existente.setPerdivel(manual.isPerdivel());
		existente.setDificuldade(manual.getDificuldade());
		
		manualRepository.save(existente);
	}

	public void excluir(Long id) {
		Manual manual = obterPorID(id);
		manualRepository.delete(manual);
	}
}
