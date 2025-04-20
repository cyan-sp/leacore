package com.gmichel.aeropuertos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.gmichel.aeropuertos.dto.AeropuertoDTO;
import com.gmichel.aeropuertos.service.AeropuertoService;
import com.gmichel.commons.controllers.CommonController;

@RestController
public class AeropuertoController
	extends CommonController<AeropuertoDTO, AeropuertoService>{

	public AeropuertoController(AeropuertoService service) {
		super(service);
	}

	
}
