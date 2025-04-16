package com.gmichel.aviones.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gmichel.commons.models.entities.AerolineaEntities;

@FeignClient(name = "microservicio-aerolineas")
public interface AerolineaCliente {
	
	@GetMapping("/{id}")
	public AerolineaEntities getAerolineaById(@PathVariable Long id);

}
