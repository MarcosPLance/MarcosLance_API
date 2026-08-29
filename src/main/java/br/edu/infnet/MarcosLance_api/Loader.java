package br.edu.infnet.MarcosLance_api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.MarcosLance_api.domain.Game;
import br.edu.infnet.MarcosLance_api.domain.Manual;
import br.edu.infnet.MarcosLance_api.domain.Trofeu;
import br.edu.infnet.MarcosLance_api.service.ManualService;



public class Loader implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		
		Game game = new Game("Uncharted","10.10.2009","Naughty Dog");

		Trofeu trofeu = new Trofeu("Onde tudo comecou", "Ouro", game);
		
		//private final ManualService manualService;
		
		game.adicionarTrofeu(trofeu);
		

		
		


		
		System.out.println(game);
		System.out.println(trofeu);
		
		for(Manual manual : trofeu.getManuais()) {
			System.out.println(manual);			
		}
		
		
		trofeu.getManuais().forEach(System.out::println);
		//manualService.obterLista().forEach(System.out::println);
		

		
	}
	

}
