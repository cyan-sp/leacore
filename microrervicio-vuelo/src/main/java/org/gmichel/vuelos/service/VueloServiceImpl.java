package org.gmichel.vuelos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmichel.commons.models.entities.VueloEntities;
import com.gmichel.commons.services.CommonServiceImpl;
import org.gmichel.vuelos.dto.VueloDTO;
import org.gmichel.vuelos.mappers.VueloMapper;
import org.gmichel.vuelos.repository.VueloRepository;

@Service
public class VueloServiceImpl extends CommonServiceImpl<VueloDTO, VueloEntities, VueloMapper, VueloRepository> implements VueloService {

    private static final Logger logger = LoggerFactory.getLogger(VueloServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<VueloDTO> listar() {
        logger.info("Fetching all vuelos");
        List<VueloDTO> lista = new ArrayList<>();
        repository.findAll().forEach(vuelo -> {
            lista.add(mapper.entityToDTO(vuelo));
        });
        logger.info("Found {} vuelos", lista.size());
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VueloDTO> obtenerPorId(Long id) {
        logger.info("Fetching vuelo with id: {}", id);
        Optional<VueloEntities> opt = repository.findById(id);
        if (opt.isPresent()) {
            logger.info("Vuelo found with id: {}", id);
            return Optional.of(mapper.entityToDTO(opt.get()));
        }
        logger.warn("Vuelo not found with id: {}", id);
        return Optional.empty();
    }

    @Override
    @Transactional
    public VueloDTO insertar(VueloDTO dto) {
        logger.info("Creating new vuelo: {}", dto.getNumeroVuelo());
        try {
            VueloEntities vuelo = mapper.dtoToEntity(dto);
            repository.save(vuelo);
            dto.setId(vuelo.getId()); // Ensure ID is set in the DTO
            logger.info("Vuelo created successfully with id: {}", vuelo.getId());
            return dto;
        } catch (Exception e) {
            logger.error("Error creating vuelo: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    @Transactional
    public VueloDTO editar(VueloDTO dto, Long id) {
        logger.info("Editing vuelo with id: {}", id);

        Optional<VueloEntities> opt = repository.findById(id);
        if (opt.isPresent()) {
            VueloEntities vuelo = opt.get();

            vuelo.setNumeroVuelo(dto.getNumeroVuelo());
            vuelo.setFechaSalida(dto.getFechaSalida());
            vuelo.setFechaLlegada(dto.getFechaLlegada());
            vuelo.setAeropuertoOrigen(dto.getAeropuertoOrigen());
            vuelo.setAeropuertoDestino(dto.getAeropuertoDestino());
            vuelo.setAvion(dto.getAvion());
            vuelo.setEstatus(dto.getEstatus());

            repository.save(vuelo);
            logger.info("Vuelo updated successfully");

            return mapper.entityToDTO(vuelo);
        }

        logger.warn("Vuelo not found with id: {}, cannot update", id);
        return null;
    }

    @Override
    @Transactional
    public VueloDTO eliminar(Long id) {
        logger.info("Deleting vuelo with id: {}", id);

        Optional<VueloEntities> opt = repository.findById(id);
        if (opt.isPresent()) {
            try {
                VueloDTO dto = mapper.entityToDTO(opt.get());
                repository.deleteById(id);
                logger.info("Vuelo deleted successfully");
                return dto;
            } catch (Exception e) {
                logger.error("Error deleting vuelo: {}", e.getMessage(), e);
                throw e;
            }
        }

        logger.warn("Vuelo not found with id: {}, cannot delete", id);
        return null;
    }
}