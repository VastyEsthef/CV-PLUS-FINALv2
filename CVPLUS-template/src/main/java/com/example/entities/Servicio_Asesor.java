package com.example.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Servicio_Asesors")
public class Servicio_Asesor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdServicio;
	
	@Column(name = "Tipo_Asesoria",length = 100,nullable = false)
	private String Tipo_Asesoria;
	
	@Column(name = "Fecha_Inicio",nullable = false)
	private LocalDate Fecha_Asesoria;
	
	@Column(name = "Estado",length = 10,nullable = false)
	private String Estado;

	
	@ManyToOne
	@JoinColumn(name="IdAdviser",nullable=false)
	private Adviser adviser;


	public Long getIdServicio() {
		return IdServicio;
	}


	public void setIdServicio(Long idServicio) {
		IdServicio = idServicio;
	}


	public String getTipo_Asesoria() {
		return Tipo_Asesoria;
	}


	public void setTipo_Asesoria(String tipo_Asesoria) {
		Tipo_Asesoria = tipo_Asesoria;
	}


	public LocalDate getFecha_Asesoria() {
		return Fecha_Asesoria;
	}


	public void setFecha_Asesoria(LocalDate fecha_Asesoria) {
		Fecha_Asesoria = fecha_Asesoria;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public Adviser getAdviser() {
		return adviser;
	}


	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}
	
	
}
