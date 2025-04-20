package com.gmichel.aviones.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(AvionServiceImpl.class);

	//Declaramos la intancia de aerolinea cliente
	@Autowired
	private AerolineaCliente client;

	@Override
	@Transactional(readOnly = true)
	public List<AvionDTO> listar() {
		logger.info("Fetching all aviones");
		List<AvionDTO> lista = new ArrayList<>();
		repository.findAll().forEach(avion -> {
			lista.add(mapper.entityToDTO(avion));
		});
		logger.info("Found {} aviones", lista.size());
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<AvionDTO> obtenerPorId(Long id) {
		logger.info("Fetching avion with id: {}", id);
		Optional<AvionEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			logger.info("Avion found with id: {}", id);
			return Optional.of(mapper.entityToDTO(opt.get()));
		}
		logger.warn("Avion not found with id: {}", id);
		return Optional.empty();
	}

	@Override
	@Transactional
	public AvionDTO insertar(AvionDTO dto) {
		logger.info("Creating new avion");
		logger.debug("Avion data: tipo={}, codigo_modelo={}, capacidad={}",
				dto.getTipo(), dto.getCodigo_modelo(), dto.getCapacidad());

		try {
			AvionEntities avion = mapper.dtoToEntity(dto);
			repository.save(avion);
			logger.info("Avion created successfully");
			return super.insertar(dto);
		} catch (Exception e) {
			logger.error("Error creating avion: {}", e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@Transactional
	public AvionDTO editar(AvionDTO dto, Long id) {
		logger.info("Editing avion with id: {}", id);

		Optional<AvionEntities> opt = repository.findById(id);
		if (opt.isPresent()) {
			AvionEntities avion = opt.get(); // Get the existing entity instead of creating a new one

			// Update the fields
			avion.setNum_registro(dto.getNum_registro());
			avion.setTipo(dto.getTipo());
			avion.setCodigo_modelo(dto.getCodigo_modelo());
			avion.setCapacidad(dto.getCapacidad());
			avion.setFecha_salida(dto.getFecha_salida());
			avion.setEstatus(dto.getEstatus());

			// Get the full aerolinea entity and set it
			try {
				AerolineaEntities aerolinea = client.getAerolineaById(dto.getAerolinea().getId());
				if (aerolinea != null) {
					avion.setAerolinea(aerolinea); // Set the full object, not just the ID reference
				}
			} catch (Exception e) {
				logger.error("Error fetching aerolinea: {}", e.getMessage(), e);
			}

			// Save the entity to the database
			avion = repository.save(avion);

			// Convert to DTO and return
			return mapper.entityToDTO(avion);
		}

		return super.editar(dto, id);
	}

	@Override
	@Transactional
	public AvionDTO eliminar(Long id) {
		logger.info("Deleting avion with id: {}", id);

		Optional<AvionEntities> opt = repository.findById(id);
		if(opt.isPresent()) {
			try {
				AvionDTO dto = mapper.entityToDTO(opt.get());
				repository.deleteById(id);
				logger.info("Avion deleted successfully");
				return dto;
			} catch (Exception e) {
				logger.error("Error deleting avion: {}", e.getMessage(), e);
				throw e;
			}
		}

		logger.warn("Avion not found with id: {}, cannot delete", id);
		return null;
	}
}