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
@Table(name="Explaboral")
public class ExpLaboral {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExpLaboral;
	
	@Column(name = "nombreInstitucionLaboral", length = 200, nullable = false)
	private String nombreInstitucionLaboral;
	
	@Column(name = "puestoLaboral", length = 200, nullable = false)
	private String puestoLaboral;
	
	@Column(name = "descripcionExpLaboral", length = 200, nullable = false)
	private String descripcionExpL;
	
	@Column(name = "fechaInicioExpLaboral",nullable = false)
	private LocalDate fechaInicioExpL;
	
	@Column(name = "fechaFinExpLaboral",nullable = false)
	private LocalDate fechaFinExpL;
	
	
	@ManyToOne
	@JoinColumn(name="id_Curriculum",nullable=false)
	private Curriculum curriculum;


	public Long getIdExpLaboral() {
		return idExpLaboral;
	}


	public void setIdExpLaboral(Long idExpLaboral) {
		this.idExpLaboral = idExpLaboral;
	}


	public String getNombreInstitucionLaboral() {
		return nombreInstitucionLaboral;
	}


	public void setNombreInstitucionLaboral(String nombreInstitucionLaboral) {
		this.nombreInstitucionLaboral = nombreInstitucionLaboral;
	}


	public String getPuestoLaboral() {
		return puestoLaboral;
	}


	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}


	public String getDescripcionExpL() {
		return descripcionExpL;
	}


	public void setDescripcionExpL(String descripcionExpL) {
		this.descripcionExpL = descripcionExpL;
	}


	public LocalDate getFechaInicioExpL() {
		return fechaInicioExpL;
	}


	public void setFechaInicioExpL(LocalDate fechaInicioExpL) {
		this.fechaInicioExpL = fechaInicioExpL;
	}


	public LocalDate getFechaFinExpL() {
		return fechaFinExpL;
	}


	public void setFechaFinExpL(LocalDate fechaFinExpL) {
		this.fechaFinExpL = fechaFinExpL;
	}


	public Curriculum getCurriculum() {
		return curriculum;
	}


	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}



	
	
	
	
}
