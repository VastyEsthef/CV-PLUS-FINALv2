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

@Entity
@Table(name="portafolios" )
public class Portafolio {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="comentario",nullable=true)
	private String comentario;
	@Column(name="valoracion",nullable=true)
	private String valoracion;
	
	@ManyToMany(mappedBy="portafolios")
	private List<Empresa> empresas=new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name="student_id")
	private Student students; 
	
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public Student getStudents() {
		return students;
	}
	public void setStudents(Student students) {
		this.students = students;
	}
	
	
}