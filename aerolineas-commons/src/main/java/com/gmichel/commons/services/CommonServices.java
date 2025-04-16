package com.gmichel.commons.services;

import java.util.List;
import java.util.Optional;

public interface CommonServices<D> {

    List<D> listar();
    
    Optional<D> obtenerPorId(Long id);

    D insertar(D dto);
    
    D editar(D entity, Long id);
    
    D eliminar(Long Id);


}
