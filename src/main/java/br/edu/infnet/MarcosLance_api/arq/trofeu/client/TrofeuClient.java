package br.edu.infnet.MarcosLance_api.arq.trofeu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.MarcosLance_api.batch.TrofeuRequest;

@FeignClient(name ="trofeu-service", url = "${trofeu.service.url}")
public interface TrofeuClient {


	@GetMapping("/trofeus/{id}")
	TrofeuResponse obterPorId(@PathVariable Long id);
	
	
	@PostMapping("/trofeus")
    void incluir (@RequestBody TrofeuRequest trofeu);
}
