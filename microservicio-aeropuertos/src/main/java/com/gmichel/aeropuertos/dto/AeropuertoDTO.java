package com.gmichel.aeropuertos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AeropuertoDTO {
	
	//CREAMOS LAS ENTIDAEDES PARA NUESTRO AEROPUERTO
	
	private Long id;

	@NotBlank(message = "El nombre no puede estar en blanco")
	private String nombre;

	@NotBlank(message = "El nombre no puede estar en blanco")
	private String codigo;

	@NotNull(message = "El nombre no puede estar en blanco")
	private Double latitud;

	@NotNull(message = "El nombre no puede estar en blanco")
	private Double longitud;
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String pais;
	
	@Min(value = 1, message = "El Estatus no puede ser menor a 1.")
	@Max(value = 2, message = "El Estatus no puede ser Mayor a 2.")
	private Long estatus;
	
	//Creamos los Getter & Setters 
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
