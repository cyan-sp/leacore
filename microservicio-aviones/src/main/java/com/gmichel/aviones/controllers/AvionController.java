package com.gmichel.aviones.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.gmichel.aviones.dto.AvionDTO;
import com.gmichel.aviones.service.AvionService;
import com.gmichel.commons.controllers.CommonController;

@RestController
//@RequestMapping("/api/v1/aviones")
public class AvionController extends CommonController<AvionDTO, AvionService>{

	public AvionController(AvionService service) {
		super(service);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@Valid @RequestBody AvionDTO dto, @PathVariable Long id, BindingResult result){
		if (result.hasErrors()) {
			return this.validate(result);
		}
		return ResponseEntity.ok(service.editar(dto, id));
	}
}
