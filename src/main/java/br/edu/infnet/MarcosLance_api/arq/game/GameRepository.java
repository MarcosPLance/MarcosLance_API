package br.edu.infnet.MarcosLance_api.arq.game;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	
	 List<Game> findByNomeContainingIgnoreCase(String nome); 
	 
}
