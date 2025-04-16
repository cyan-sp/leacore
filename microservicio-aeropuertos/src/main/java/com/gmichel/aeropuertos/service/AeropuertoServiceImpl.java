package com.gmichel.aeropuertos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmichel.aeropuertos.dto.AeropuertoDTO;
import com.gmichel.aeropuertos.mappers.AeropuertoMapper;
import com.gmichel.aeropuertos.repository.AeropuertoRepository;
import com.gmichel.commons.models.entities.AeropuertoEntities;
import com.gmichel.commons.services.CommonServiceImpl;

@Service
public class AeropuertoServiceImpl
	extends CommonServiceImpl< AeropuertoDTO, AeropuertoEntities, AeropuertoMapper, AeropuertoRepository > 
		implements AeropuertoService{

	@Override
	@Transactional(readOnly = true)
	public List<AeropuertoDTO> listar() {
		List<AeropuertoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(aeropuerto -> {
			lista.add(mapper.entityToDTO(aeropuerto));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<AeropuertoDTO> obtenerPorId(Long id) {
		Optional<AeropuertoEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public AeropuertoDTO insertar(AeropuertoDTO dto) {
		AeropuertoEntities aeropuerto = mapper.dtoToEntity(dto);
		repository.save(aeropuerto);
		return super.insertar(dto);
	}

	@Override
	@Transactional
	public AeropuertoDTO editar(AeropuertoDTO entity, Long id) {
		Optional<AeropuertoEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			AeropuertoEntities aeropuerto = opt.get();
			aeropuerto.setNombre(entity.getNombre());
			aeropuerto.setCodigo(entity.getCodigo());
			aeropuerto.setLatitud(entity.getLatitud());
			aeropuerto.setLongitud(entity.getLongitud());
			aeropuerto.setPais(entity.getPais());
			aeropuerto.setEstatus(entity.getEstatus());
			repository.save(aeropuerto);
			
			return mapper.entityToDTO(aeropuerto);
		}
		return super.editar(entity, id);
	}

	@Override
	@Transactional
	public AeropuertoDTO eliminar(Long Id) {
		Optional<AeropuertoEntities> opt = repository.findById(Id);
		if(opt.isPresent()) {
			AeropuertoDTO dto = mapper.entityToDTO(opt.get());
			repository.deleteById(Id);
			return dto;
					
		}
		return null;
	}

	
}
