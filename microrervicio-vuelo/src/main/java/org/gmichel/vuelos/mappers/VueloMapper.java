package org.gmichel.vuelos.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gmichel.commons.mappers.CommonMapper;
import com.gmichel.commons.models.entities.VueloEntities;
import org.gmichel.vuelos.dto.VueloDTO;
import org.gmichel.vuelos.interfaces.AeropuertoCliente;
import org.gmichel.vuelos.interfaces.AvionCliente;
import org.gmichel.vuelos.repository.VueloRepository;

@Component
public class VueloMapper extends CommonMapper<VueloDTO, VueloEntities, VueloRepository> {

    @Autowired
    private AeropuertoCliente aeropuertoCliente;

    @Autowired
    private AvionCliente avionCliente;

    @Override
    public VueloDTO entityToDTO(VueloEntities entity) {
        VueloDTO dto = new VueloDTO();
        dto.setId(entity.getId());
        dto.setNumeroVuelo(entity.getNumeroVuelo());
        dto.setFechaSalida(entity.getFechaSalida());
        dto.setFechaLlegada(entity.getFechaLlegada());
        dto.setAeropuertoOrigen(entity.getAeropuertoOrigen());
        dto.setAeropuertoDestino(entity.getAeropuertoDestino());
        dto.setAvion(entity.getAvion());
        dto.setEstatus(entity.getEstatus());
        return dto;
    }

    @Override
    public VueloEntities dtoToEntity(VueloDTO dto) {
        VueloEntities entity = new VueloEntities();
        entity.setId(dto.getId());
        entity.setNumeroVuelo(dto.getNumeroVuelo());
        entity.setFechaSalida(dto.getFechaSalida());
        entity.setFechaLlegada(dto.getFechaLlegada());

        // Handle relationships with error checking
        try {
            if (dto.getAeropuertoOrigen() != null && dto.getAeropuertoOrigen().getId() != null) {
                entity.setAeropuertoOrigen(aeropuertoCliente.getAeropuertoById(dto.getAeropuertoOrigen().getId()));
            }

            if (dto.getAeropuertoDestino() != null && dto.getAeropuertoDestino().getId() != null) {
                entity.setAeropuertoDestino(aeropuertoCliente.getAeropuertoById(dto.getAeropuertoDestino().getId()));
            }

            if (dto.getAvion() != null && dto.getAvion().getId() != null) {
                entity.setAvion(avionCliente.getAvionById(dto.getAvion().getId()));
            }
        } catch (Exception e) {
            // Log the error but continue with simple references
            entity.setAeropuertoOrigen(dto.getAeropuertoOrigen());
            entity.setAeropuertoDestino(dto.getAeropuertoDestino());
            entity.setAvion(dto.getAvion());
        }

        entity.setEstatus(dto.getEstatus());
        return entity;
    }
}