package com.gmichel.aviones.dto;

import java.time.LocalDate;


public class AreolineaDTO {
	
	//CREAMOS NUESTRAS ENTIDADES PARA NUESTRA AEROLINEA
		
		private Long id;
		private String nombre;
		private String iata; 
		private Long estatus;
		private String pais;
		private LocalDate fecha;
		
		//CREAMOS LOS GETTERS AND SETTERS 
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
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		
		
		
}
