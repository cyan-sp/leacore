package com.gmichel.aeropuertos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmichel.commons.models.entities.AeropuertoEntities;

public interface AeropuertoRepository 
	extends JpaRepository<AeropuertoEntities, Long> {
	
}
