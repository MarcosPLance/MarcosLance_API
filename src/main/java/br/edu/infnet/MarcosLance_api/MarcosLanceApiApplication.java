package br.edu.infnet.MarcosLance_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.edu.infnet.MarcosLance_api.arq.game.Game;

@SpringBootApplication
@EnableFeignClients
public class MarcosLanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcosLanceApiApplication.class, args);
	}

}
