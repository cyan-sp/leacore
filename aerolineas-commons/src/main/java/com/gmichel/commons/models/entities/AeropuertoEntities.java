package com.gmichel.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "AEROPUERTOS")
public class AeropuertoEntities {
		@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AEROPUERTO")
    @SequenceGenerator(name = "SEQ_AEROPUERTO", sequenceName = "SEQ_AEROPUERTO", allocationSize = 1)
    @Column(name = "ID_AEROPUERTO")
	private Long id;
   
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "LATITUD")
	private Double latitud;
	
	@Column(name = "LONGITUD")
	private Double longitud;
	
	@Column(name = "PAIS")
	private String pais;
	
	@Column(name = "ID_ESTATUS")
	private Long estatus;

	// CREAMOS EL CONSTRUCTOR POR DEFECTO CON VALUES
	public AeropuertoEntities(Long id, String nombre, String codigo, Double latitud, Double longitud, String pais,
			Long estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.pais = pais;
		this.estatus = estatus;
	}
	
	public AeropuertoEntities() {
		// TODO Auto-generated constructor stub
	}

	///iNGRESAMOS GETTERS AND SETTERS
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}
	
}
