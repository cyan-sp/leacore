package com.gmichel.commons.models.entities;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "AEROLINEAS")
public class AerolineaEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AEROLINEA")
    @SequenceGenerator(name = "SEQ_AEROLINEA", sequenceName = "SEQ_AEROLINEA", allocationSize = 1)
    @Column(name = "ID_AEROLINEA")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "IATA")
    private String iata;
    @Column(name = "ID_ESTATUS")
    private Long estatus;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "FECHA_FUNDACION")
    private LocalDate fechaFundacion;
    
    //CREAMOS EL CONSTRUCTOR DE LAS ENTIDADES DE AEROLINEA
    public AerolineaEntities(Long id, String nombre, String iata, Long estatus, String pais, LocalDate fechaFundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.iata = iata;
		this.estatus = estatus;
		this.pais = pais;
		this.fechaFundacion = fechaFundacion;
	}

	///iNGRESAMOS GETTERS AND SETTERS

    public AerolineaEntities() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Long getEstatus() {
        return estatus;
    }

    public void setEstatus(Long estatus) {
        this.estatus = estatus;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }


}
