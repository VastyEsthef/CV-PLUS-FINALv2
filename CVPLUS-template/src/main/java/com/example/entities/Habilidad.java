package com.example.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="habilidades")
public class Habilidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHabilidad;
	
	@Column(name = "nombreHabilidad", length = 50, nullable = false)
	private String nombreHabilidad;
	
	@Column(name = "descripcionHabilidad", length = 200, nullable = false)
	private String descripcionHabilidad;
	
	@Column(name = "nivelHabilidad", length = 50, nullable = false)
	private String nivelHabilidad;
	
	
	@ManyToOne
	@JoinColumn(name="id_Curriculum",nullable=false)
	private Curriculum curriculum;


	public Long getIdHabilidad() {
		return idHabilidad;
	}


	public void setIdHabilidad(Long idHabilidad) {
		this.idHabilidad = idHabilidad;
	}


	public String getNombreHabilidad() {
		return nombreHabilidad;
	}


	public void setNombreHabilidad(String nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}


	public String getDescripcionHabilidad() {
		return descripcionHabilidad;
	}


	public void setDescripcionHabilidad(String descripcionHabilidad) {
		this.descripcionHabilidad = descripcionHabilidad;
	}


	public String getNivelHabilidad() {
		return nivelHabilidad;
	}


	public void setNivelHabilidad(String nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}


	public Curriculum getCurriculum() {
		return curriculum;
	}


	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}


	





	
	
}