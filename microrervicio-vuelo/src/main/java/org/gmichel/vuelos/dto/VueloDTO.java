package org.gmichel.vuelos.dto;

import com.gmichel.commons.models.entities.AeropuertoEntities;
import com.gmichel.commons.models.entities.AvionEntities;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VueloDTO {

    private Long id;

    @NotBlank(message = "El número de vuelo no puede estar en blanco")
    private String numeroVuelo;

    @NotNull(message = "La fecha de salida no puede ser nula")
    private LocalDateTime fechaSalida;

    @NotNull(message = "La fecha de llegada no puede ser nula")
    @Future(message = "La fecha de llegada debe ser posterior a la fecha actual")
    private LocalDateTime fechaLlegada;

    @NotNull(message = "El aeropuerto de origen no puede ser nulo")
    private AeropuertoEntities aeropuertoOrigen;

    @NotNull(message = "El aeropuerto de destino no puede ser nulo")
    private AeropuertoEntities aeropuertoDestino;

    @NotNull(message = "El avión no puede ser nulo")
    private AvionEntities avion;

    @NotNull(message = "El estatus no puede ser nulo")
    private Long estatus;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public AeropuertoEntities getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(AeropuertoEntities aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public AeropuertoEntities getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(AeropuertoEntities aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public AvionEntities getAvion() {
        return avion;
    }

    public void setAvion(AvionEntities avion) {
        this.avion = avion;
    }

    public Long getEstatus() {
        return estatus;
    }

    public void setEstatus(Long estatus) {
        this.estatus = estatus;
    }
}