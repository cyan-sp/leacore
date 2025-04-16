package com.gmichel.aviones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gmichel.commons.models.entities.AvionEntities;

public interface AvionRepository 
	extends JpaRepository<AvionEntities, Long>{ 

}
