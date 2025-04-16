package com.gmichel.aviones.dto;

import java.time.LocalDate;

import com.gmichel.commons.models.entities.AerolineaEntities;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class AvionDTO {
	
		//CREAMOS NUESTRAS ENTIDADES PARA NUESTRA AEROLINEA
		private Long id;
		
		@NotNull(message = "NUM_REGISTRO")
	    private int num_registro;
		@NotBlank(message = "TIPO")
	    private String tipo;
		@NotBlank(message = "CODIGO_MODELO")
		private String codigo_modelo;
		@Min(value = 1, message = "La cantidad no puede ser no puede ser menor a 1.")
		private int capacidad;
		@Future(message = "La fecha de salida no debe ser posterior a la fecha actual")
		private LocalDate fecha_salida;
		
		@Min(value = 1, message = "El Estatus no puede ser menor a 1.")
		@Max(value = 2, message = "El Estatus no puede ser Mayor a 2.")
		private Long estatus;
		
		@NotNull(message = "La Aerolina no puede ir vacia.")
		private AerolineaEntities aerolinea;

		
		//CREAMOS LOS GETTERS AND SETTERS 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getNum_registro() {
			return num_registro;
		}

		public void setNum_registro(int num_registro) {
			this.num_registro = num_registro;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getCodigo_modelo() {
			return codigo_modelo;
		}

		public void setCodigo_modelo(String codigo_modelo) {
			this.codigo_modelo = codigo_modelo;
		}

		public int getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		public LocalDate getFecha_salida() {
			return fecha_salida;
		}

		public void setFecha_salida(LocalDate fecha_salida) {
			this.fecha_salida = fecha_salida;
		}

		public Long getEstatus() {
			return estatus;
		}

		public void setEstatus(Long estatus) {
			this.estatus = estatus;
		}

		public AerolineaEntities getAerolinea() {
			return aerolinea;
		}

		public void setAerolinea(AerolineaEntities aerolinea) {
			this.aerolinea = aerolinea;
		}

}
