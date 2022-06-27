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
@Table(name = "advisories")
public class Advisory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAsesoria;

	@Column(name = "Dia", nullable = false)
	private String dia;
	
	@ManyToOne
	@JoinColumn(name = "idStudent", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "idServicioAdviser", nullable = false)
	private ServicioXAdviser servicioAdviser;
	
	public Advisory() {
		
	}

	
	public Advisory (Long idAsesoria, String dia, Student student, ServicioXAdviser servicioAdviser) {
		
		this.idAsesoria = idAsesoria;
		this.dia = dia;
		this.student = student;
		this.servicioAdviser= servicioAdviser;
	}
	
	public Long getIdAsesoria() {
		return idAsesoria;
	}

	public void setIdAsesoria(Long idAsesoria) {
		this.idAsesoria = idAsesoria;
	}
	
	
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ServicioXAdviser getServicioAdviser() {
		return servicioAdviser;
	}

	public void setServicioAdviser(ServicioXAdviser servicioAdviser) {
		this.servicioAdviser = servicioAdviser;
	}
	

}
