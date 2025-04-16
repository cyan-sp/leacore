package com.gmichel.aviones.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gmichel.aviones.dto.AvionDTO;
import com.gmichel.aviones.service.AvionService;
import com.gmichel.commons.controllers.CommonController;

@RestController
//@RequestMapping("/api/v1/aviones")
public class AvionController extends CommonController<AvionDTO, AvionService>{

	public AvionController(AvionService service) {
		super(service);
	} 
}
