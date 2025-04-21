package org.gmichel.vuelos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.gmichel.commons.controllers.CommonController;
import org.gmichel.vuelos.dto.VueloDTO;
import org.gmichel.vuelos.service.VueloService;

@RestController
public class VueloController extends CommonController<VueloDTO, VueloService> {

    public VueloController(VueloService service) {
        super(service);
    }
}