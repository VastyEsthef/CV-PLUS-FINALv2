package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "portafolios2")
public class Portafolio2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPortafolio;
	
	@NotEmpty(message = "Ingresar el titulo del portafolio")
	@Column(name = "Nombre_Porta", length = 50, nullable = false)
	private String NombrePortafolio;
	
	@NotEmpty(message = "Ingresar la descripcion del portafolio")
	@Column(name = "Descripcion_Portafolio", length =500, nullable = false)
	private String DescripcionPortafolio;
	
	@ManyToOne
	@JoinColumn(name="IdStudent",nullable=true)
	private Student student;
	
	
	public Portafolio2() {
	}
	
	public Portafolio2(String NombrePortafolio) {
		this.NombrePortafolio = NombrePortafolio;
		
	}
	
	
	
	@ManyToMany(mappedBy="portafolios")
	private List<Proyecto>proyectos=new ArrayList<>();
	

	
	public String getDescripcionPortafolio() {
		return DescripcionPortafolio;
	}

	public void setDescripcionPortafolio(String descripcionPortafolio) {
		DescripcionPortafolio = descripcionPortafolio;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Long getIdPortafolio() {
		return IdPortafolio;
	}

	public void setIdPortafolio(Long idPortafolio) {
		IdPortafolio = idPortafolio;
	}

	public String getNombrePortafolio() {
		return NombrePortafolio;
	}

	public void setNombrePortafolio(String nombrePortafolio) {
		NombrePortafolio = nombrePortafolio;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}




}