package com.gmichel.aviones.mappers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gmichel.aviones.dto.AvionDTO;
import com.gmichel.aviones.interfaces.AerolineaCliente;
import com.gmichel.aviones.repository.AvionRepository;
import com.gmichel.commons.mappers.CommonMapper;
import com.gmichel.commons.models.entities.AerolineaEntities;
import com.gmichel.commons.models.entities.AeropuertoEntities;
import com.gmichel.commons.models.entities.AvionEntities;

import ch.qos.logback.core.net.server.Client;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Component
public class AvionMapper extends CommonMapper<AvionDTO, AvionEntities, AvionRepository> {
	
	@Autowired
	private AerolineaCliente client;
	 
		
		@Override
		public AvionDTO entityToDTO(AvionEntities  entity) {
			AvionDTO dto = new AvionDTO();   
			dto.setId(entity.getId());
			dto.setNum_registro(entity.getNum_registro());
			dto.setTipo(entity.getTipo());
			dto.setCodigo_modelo(entity.getCodigo_modelo());
			dto.setCapacidad(entity.getCapacidad());
			dto.setFecha_salida(entity.getFecha_salida());
			dto.setEstatus(entity.getEstatus());
			dto.setAerolinea(entity.getAerolinea());
			return dto;
		}
		
		@Override
		public AvionEntities dtoToEntity(AvionDTO dto) {
			AvionEntities entity = new AvionEntities();
			entity.setId(dto.getId());
			entity.setNum_registro(dto.getNum_registro());
			entity.setTipo(dto.getTipo());
			entity.setCodigo_modelo(dto.getCodigo_modelo());
			entity.setCapacidad(dto.getCapacidad());
			entity.setFecha_salida(dto.getFecha_salida());
			entity.setEstatus(dto.getEstatus());
			AerolineaEntities aerolinea = client.getAerolineaById(dto.getAerolinea().getId());
			if (aerolinea != null) {				
				entity.setAerolinea(dto.getAerolinea());
			}
			
			return entity;
		}
	
}
