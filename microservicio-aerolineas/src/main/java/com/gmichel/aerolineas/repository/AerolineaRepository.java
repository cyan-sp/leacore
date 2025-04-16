package com.gmichel.aerolineas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmichel.commons.models.entities.AerolineaEntities;

public interface AerolineaRepository extends JpaRepository<AerolineaEntities, Long>{

}
