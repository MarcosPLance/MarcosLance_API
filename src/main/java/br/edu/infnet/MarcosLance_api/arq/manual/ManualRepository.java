package br.edu.infnet.MarcosLance_api.arq.manual;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualRepository extends JpaRepository<Manual, Long> {
	
	List<Manual> findByPerdivelTrue();
	
	List<Manual> findByTituloContainingIgnoreCase(String titulo); 

}
