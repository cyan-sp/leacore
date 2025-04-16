package com.gmichel.aviones.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmichel.aviones.dto.AvionDTO;
import com.gmichel.aviones.interfaces.AerolineaCliente;
import com.gmichel.aviones.mappers.AvionMapper;
import com.gmichel.aviones.repository.AvionRepository;
import com.gmichel.commons.models.entities.AerolineaEntities;
import com.gmichel.commons.models.entities.AvionEntities;
import com.gmichel.commons.services.CommonServiceImpl;

@Service
public class AvionServiceImpl 
	extends CommonServiceImpl< AvionDTO, AvionEntities, AvionMapper, AvionRepository > 
		implements AvionService {
	
	//Declaramos la intancia de aerolinea cliente
	@Autowired
	private AerolineaCliente client;

	@Override
	@Transactional(readOnly = true)
	public List<AvionDTO> listar() {
		List<AvionDTO> lista = new ArrayList<>();
		repository.findAll().forEach(avion -> {
			lista.add(mapper.entityToDTO(avion));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<AvionDTO> obtenerPorId(Long id) {
		Optional<AvionEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public AvionDTO insertar(AvionDTO dto) {
		AvionEntities avion = mapper.dtoToEntity(dto);
		repository.save(avion);
		return super.insertar(dto);
	}

	@Override
	public AvionDTO editar(AvionDTO dto, Long id) {
		Optional<AvionEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			AvionEntities avion = new AvionEntities();
			avion.setId(dto.getId());
			avion.setNum_registro(dto.getNum_registro());
			avion.setTipo(dto.getTipo());
			avion.setCodigo_modelo(dto.getCodigo_modelo());
			avion.setCapacidad(dto.getCapacidad());
			avion.setFecha_salida(dto.getFecha_salida());
			avion.setEstatus(dto.getEstatus());
			AerolineaEntities aerolinea = client.getAerolineaById(dto.getAerolinea().getId());
			if (aerolinea != null) {				
				avion.setAerolinea(dto.getAerolinea());
			}
			return mapper.entityToDTO(avion);
		}
		return super.editar(dto, id);
	}

	@Override
	public AvionDTO eliminar(Long Id) {
		Optional<AvionEntities> opt = repository.findById(Id);
		if(opt.isPresent()) {
			AvionDTO dto = mapper.entityToDTO(opt.get());
			repository.deleteById(Id);
			return dto;
		}
		return null;
	}
	

}
