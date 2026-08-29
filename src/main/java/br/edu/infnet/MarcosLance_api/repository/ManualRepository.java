package br.edu.infnet.MarcosLance_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.MarcosLance_api.domain.Manual;

public interface ManualRepository extends JpaRepository<Manual, Long> {
	
	List<Manual> findByPerdivelTrue();
	
	List<Manual> findByTituloContainingIgnoreCase(String titulo); 

}
