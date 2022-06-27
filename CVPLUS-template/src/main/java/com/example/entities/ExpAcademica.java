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
@Table(name = "expAcademica")
public class ExpAcademica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExpAcademica;

	@Column(name = "nombreInstitucionAcademica", length = 200, nullable = false)
	private String nombreInstitucionAcademica;
	
	@Column(name = "descripcionExpAcademica", length = 200, nullable = false)
	private String descripcionExpAcademica;

	@Column(name = "fechaInicioExpAcademica", nullable = false)
	private LocalDate fechaInicioExpAcademica;

	public Long getIdExpAcademica() {
		return idExpAcademica;
	}

	public void setIdExpAcademica(Long idExpAcademica) {
		this.idExpAcademica = idExpAcademica;
	}

	public String getNombreInstitucionAcademica() {
		return nombreInstitucionAcademica;
	}

	public void setNombreInstitucionAcademica(String nombreInstitucionAcademica) {
		this.nombreInstitucionAcademica = nombreInstitucionAcademica;
	}

	public String getDescripcionExpAcademica() {
		return descripcionExpAcademica;
	}

	public void setDescripcionExpAcademica(String descripcionExpAcademica) {
		this.descripcionExpAcademica = descripcionExpAcademica;
	}

	public LocalDate getFechaInicioExpAcademica() {
		return fechaInicioExpAcademica;
	}

	public void setFechaInicioExpAcademica(LocalDate fechaInicioExpAcademica) {
		this.fechaInicioExpAcademica = fechaInicioExpAcademica;
	}

	public LocalDate getFechaFinExpAcademica() {
		return fechaFinExpAcademica;
	}

	public void setFechaFinExpAcademica(LocalDate fechaFinExpAcademica) {
		this.fechaFinExpAcademica = fechaFinExpAcademica;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	@Column(name = "fechaFinExpAcademica", nullable = false)
	private LocalDate fechaFinExpAcademica;

	@ManyToOne
	@JoinColumn(name = "id_Curriculum", nullable = false)
	private Curriculum curriculum;
	

}