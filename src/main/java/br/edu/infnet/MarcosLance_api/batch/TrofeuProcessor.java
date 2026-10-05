package br.edu.infnet.MarcosLance_api.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class TrofeuProcessor implements ItemProcessor<TrofeuBatch, TrofeuRequest> {
	
	private static final Logger log = 
			LoggerFactory.getLogger(TrofeuProcessor.class);
	
	
	@Override
	public TrofeuRequest process(TrofeuBatch trofeu) throws Exception{
		
		TrofeuRequest processado = new TrofeuRequest(
				trofeu.getNome().trim().toUpperCase(),
				trofeu.getTipo()
				);
		
		log.info("PROCESSOR: {} -> {}", trofeu, processado);
		
		return processado;
	}
}
