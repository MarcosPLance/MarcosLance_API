package br.edu.infnet.MarcosLance_api.arq.trofeu.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.MarcosLance_api.arq.trofeu.exception.TrofeuRemotoNaoEncontradoException;
import br.edu.infnet.MarcosLance_api.arq.trofeu.exception.TrofeuServiceIndisponivelException;
import feign.FeignException;
import feign.RetryableException;

@Component
public class TrofeuGateway {

	private final TrofeuClient trofeuClient;
	
	public TrofeuGateway (TrofeuClient trofeuClient) {
		this.trofeuClient = trofeuClient;
	}
	
	public TrofeuResponse obterPorId(@PathVariable Long id) {
		try {
		return trofeuClient.obterPorId(id);
		}catch(FeignException.NotFound e) {
			throw new TrofeuRemotoNaoEncontradoException(id);
		}catch(RetryableException e) {
			throw new TrofeuServiceIndisponivelException();
		}
	}
}	
