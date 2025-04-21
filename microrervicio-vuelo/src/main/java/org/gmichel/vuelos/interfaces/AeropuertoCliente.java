package org.gmichel.vuelos.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gmichel.commons.models.entities.AeropuertoEntities;

@FeignClient(name = "microservicio-aeropuertos")
public interface AeropuertoCliente {

    @GetMapping("/{id}")
    public AeropuertoEntities getAeropuertoById(@PathVariable Long id);
}