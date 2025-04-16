package com.gmichel.commons.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AVIONES")
public class AvionEntities<Aeropuerto> {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AVION")
    @SequenceGenerator(name = "SEQ_AVION", sequenceName = "SEQ_AVION", allocationSize = 1)
    @Column(name = "ID_AVION")
    private Long id;
	
	@Column(name = "NUM_REGISTRO")
    private int num_registro;
	@Column(name = "TIPO")
    private String tipo;
	@Column(name = "CODIGO_MODELO")
	private String codigo_modelo;
	@Column(name = "CAPACIDAD")
	private int capacidad;
	@Column(name = "FECHA_SALIDA")
	private LocalDate fecha_salida;
	@Column(name = "ID_ESTATUS")
	private Long estatus;
	
	@ManyToOne
	@JoinColumn(name = "ID_AEROLINEA", referencedColumnName = "ID_AEROLINEA")
	private AerolineaEntities aerolinea;
	
	public AvionEntities() {
		// TODO Auto-generated constructor stub
	}

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
