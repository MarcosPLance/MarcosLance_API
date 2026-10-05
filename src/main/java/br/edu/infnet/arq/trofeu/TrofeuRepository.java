package br.edu.infnet.arq.trofeu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrofeuRepository extends JpaRepository<Trofeu, Long>{

	
	List<Trofeu> findByNomeContainingIgnoreCase(String nome);


	
}
