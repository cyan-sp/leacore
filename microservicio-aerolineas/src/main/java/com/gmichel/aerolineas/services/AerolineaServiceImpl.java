package com.gmichel.aerolineas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmichel.aerolineas.dto.AerolineaDTO;
import com.gmichel.aerolineas.mappers.AerolineaMapper;
import com.gmichel.aerolineas.repository.AerolineaRepository;
import com.gmichel.commons.models.entities.AerolineaEntities;
import com.gmichel.commons.services.CommonServiceImpl;

@Service
public class AerolineaServiceImpl 
	extends CommonServiceImpl<AerolineaDTO, AerolineaEntities, AerolineaMapper, AerolineaRepository>
		implements AerolineaService{
	
	@Override
	@Transactional(readOnly = true)
	public List<AerolineaDTO>listar(){
		List<AerolineaDTO> lista = new ArrayList<>();
		repository.findAll().forEach(aerolinea -> {
			lista.add(mapper.entityToDTO(aerolinea));
		});
		return lista;	
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<AerolineaDTO> obtenerPorId(Long id) {
		Optional<AerolineaEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return Optional.empty();
	}
	
	@Override
	@Transactional
	public AerolineaDTO insertar(AerolineaDTO dto) {
		AerolineaEntities aerolinea = mapper.dtoToEntity(dto);
		repository.save(aerolinea);
		return dto;
	}
	
	@Override
	@Transactional
	public AerolineaDTO editar(AerolineaDTO entity, Long Id) {
		Optional<AerolineaEntities> opt = repository.findById(Id);
		if (opt.isPresent()) {
			AerolineaEntities aerolinea = opt.get();
			aerolinea.setNombre(entity.getNombre());
			aerolinea.setIata(entity.getIata());
			aerolinea.setPais(entity.getPais());
			aerolinea.setEstatus(entity.getEstatus());
			aerolinea.setFechaFundacion(entity.getFecha());
			repository.save(aerolinea);
			
			return mapper.entityToDTO(aerolinea);
		}
		return null;
	}
	
	@Override
	@Transactional
	public AerolineaDTO eliminar(Long id) {
		Optional<AerolineaEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			AerolineaDTO dto = mapper.entityToDTO(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}

}
