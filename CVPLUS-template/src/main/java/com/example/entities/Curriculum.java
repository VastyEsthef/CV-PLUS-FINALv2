package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curriculums")
public class Curriculum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id_Curriculum;
	
	@Column(name = "Introduccion", length = 200, nullable = false)
	private String Introduccion;
	
	@ManyToOne
	@JoinColumn(name="IdStudent",nullable=false)
	private Student student;
    
	
	public Long getId_Curriculum() {
		return Id_Curriculum;
	}

	public void setId_Curriculum(Long id_Curriculum) {
		Id_Curriculum = id_Curriculum;
	}

	public String getIntroduccion() {
		return Introduccion;
	}

	public void setIntroduccion(String introduccion) {
		Introduccion = introduccion;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	


	


}