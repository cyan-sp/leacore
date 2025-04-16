package com.gmichel.aerolineas.mappers;

import org.springframework.stereotype.Component;

import com.gmichel.aerolineas.dto.AerolineaDTO;
import com.gmichel.aerolineas.repository.AerolineaRepository;
import com.gmichel.commons.mappers.CommonMapper;
import com.gmichel.commons.models.entities.AerolineaEntities;

@Component
public class AerolineaMapper 
	extends CommonMapper<AerolineaDTO, AerolineaEntities, AerolineaRepository>{
	
	@Override
	public AerolineaDTO entityToDTO(AerolineaEntities  entity) {
		AerolineaDTO dto = new AerolineaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setIata(entity.getIata());
		dto.setPais(entity.getPais());
		dto.setEstatus(entity.getEstatus());
		dto.setFecha(entity.getFechaFundacion());
		return dto;
	}
	
	@Override
	public AerolineaEntities dtoToEntity(AerolineaDTO dto) {
		AerolineaEntities entity= new AerolineaEntities();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setIata(dto.getIata());
		entity.setPais(dto.getPais());
		entity.setEstatus(dto.getEstatus());
		entity.setFechaFundacion(dto.getFecha());
		return entity;
	}

}
