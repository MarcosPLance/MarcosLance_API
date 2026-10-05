package br.edu.infnet.MarcosLance_api.arq.jogador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	
	//public List<Jogador> findByNomeConainingIgnoreCase(Strinf nome);

	//Optional<Jogador>

}
