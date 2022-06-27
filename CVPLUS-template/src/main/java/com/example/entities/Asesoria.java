package com.example.entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Asesorias")
public class Asesoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdAsesoria;
	
	@Column(name = "Precio",nullable = false)
	private float Precio;
	
	@Column(name = "Fecha_Inicio",nullable = false)
	private LocalDateTime Fecha_Inicio;
	
	@Column(name = "Fecha_Fin",nullable = false)
	private LocalDateTime Fecha_Fin;
	
	
	@ManyToOne
	@JoinColumn(name="IdStudent",nullable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="IdServicio",nullable=false)
	private Servicio_Asesor servicio_asesor;

	
	
	public Long getIdAsesoria() {
		return IdAsesoria;
	}

	public void setIdAsesoria(Long idAsesoria) {
		IdAsesoria = idAsesoria;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public LocalDateTime getFecha_Inicio() {
		return Fecha_Inicio;
	}

	public void setFecha_Inicio(LocalDateTime fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}

	public LocalDateTime getFecha_Fin() {
		return Fecha_Fin;
	}

	public void setFecha_Fin(LocalDateTime fecha_Fin) {
		Fecha_Fin = fecha_Fin;
	}

	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Servicio_Asesor getServicio_asesor() {
		return servicio_asesor;
	}

	public void setServicio_asesor(Servicio_Asesor servicio_asesor) {
		this.servicio_asesor = servicio_asesor;
	}

	
	
	
}