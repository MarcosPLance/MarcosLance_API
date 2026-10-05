package br.edu.infnet.MarcosLance_api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.edu.infnet.MarcosLance_api.arq.game.Game;
import br.edu.infnet.MarcosLance_api.arq.manual.Manual;
import br.edu.infnet.MarcosLance_api.domain.Identificavel;
import br.edu.infnet.MarcosLance_api.exception.IdentificadorDuplicadoException;
import br.edu.infnet.MarcosLance_api.exception.RecursoNaoEncontradoException;

public abstract class BaseService<T extends Identificavel> {

	private void validarObjeto(T objeto) {
		if(objeto == null) {
			throw new IllegalArgumentException("O objeto nao pode ser nulo");
		}

		if(objeto.getID() == null) {
			throw new IllegalArgumentException("O identificador nao pode ser nulo");
		}

	}

	private final Map<Long, T> dados = new LinkedHashMap<Long, T>();
	
	public void incluir(T objeto) {

		validarObjeto(objeto);
		
		if(dados.containsKey(objeto.getID())) {
			throw new IdentificadorDuplicadoException("Nenhum recurso encontrado para esse identificador");
		}	
		
		
		dados.put(objeto.getID(), objeto);
		
		
		
	}

	
	public void alterar(T objeto) {
		
		validarObjeto(objeto);
		
		verificarExistencia(objeto.getID());
				
		dados.put(objeto.getID(), objeto);
	}
	
	public void excluir(Long ID) {
		verificarExistencia(ID);
		dados.remove(ID);
	}
	
	public List<T> obterLista(){
		
		
		
		return new ArrayList<T>(dados.values());
	}
	
	
	public T obterPorId(Long ID) {
		return dados.get(ID);
	}

	private void verificarExistencia(Long id){
		if(id == null) {
			throw new IllegalArgumentException("Id nao pode ser nulo");
		}
		
		if(!dados.containsKey(id)) {
			throw new RecursoNaoEncontradoException("Nenhum recurso encontrado");
		}
	}
	
}
