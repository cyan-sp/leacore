package org.gmichel.vuelos.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gmichel.commons.models.entities.AvionEntities;

@FeignClient(name = "microservicio-aviones")
public interface AvionCliente {

    @GetMapping("/{id}")
    public AvionEntities getAvionById(@PathVariable Long id);
}