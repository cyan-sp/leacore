package com.gmichel.aeropuertos.mappers;

import org.springframework.stereotype.Component;

import com.gmichel.aeropuertos.dto.AeropuertoDTO;
import com.gmichel.aeropuertos.repository.AeropuertoRepository;
import com.gmichel.commons.mappers.CommonMapper;
import com.gmichel.commons.models.entities.AeropuertoEntities;

@Component
public class AeropuertoMapper 
	extends CommonMapper<AeropuertoDTO, 
		AeropuertoEntities, AeropuertoRepository>{
	
	@Override 
	public AeropuertoDTO entityToDTO(AeropuertoEntities entity) {
		
		AeropuertoDTO dto = new AeropuertoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setCodigo(entity.getCodigo());
		dto.setLatitud(entity.getLatitud());
		dto.setLongitud(entity.getLongitud());
		dto.setPais(entity.getPais());
		dto.setEstatus(entity.getEstatus());
		return dto;
	}
	
	@Override 
	public AeropuertoEntities dtoToEntity(AeropuertoDTO dto) {
		
		AeropuertoEntities entity = new AeropuertoEntities();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setCodigo(dto.getCodigo());
		entity.setLatitud(dto.getLatitud());
		entity.setLongitud(dto.getLongitud());
		entity.setPais(dto.getPais());
		entity.setEstatus(dto.getEstatus());
		return entity;
	}

	
}
