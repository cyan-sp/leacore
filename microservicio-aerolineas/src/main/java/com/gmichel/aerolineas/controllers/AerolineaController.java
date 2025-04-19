package com.gmichel.aerolineas.controllers;

//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmichel.aerolineas.dto.AerolineaDTO;
import com.gmichel.aerolineas.services.AerolineaService;
import com.gmichel.commons.controllers.CommonController;


//@RequestMapping("/api/v1/aerolineas")
@RestController
public class AerolineaController 
	extends CommonController<AerolineaDTO, AerolineaService>{

	public AerolineaController(AerolineaService service) {
		super(service);
	}



}
