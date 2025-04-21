package org.gmichel.vuelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmichel.commons.models.entities.VueloEntities;

public interface VueloRepository extends JpaRepository<VueloEntities, Long> {
    // You can add custom query methods here if needed
}