package com.example.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "proyecto")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdProyecto;

	@Column(name = "Titulo_Proyect", length = 100, nullable = false)
	private String Titulo_Proyect;

	@Column(name = "Descripcion_Proyect", length = 500, nullable = false)
	private String Descripcion_Proyect;

	@Column(name = "Colaboradores", length = 200)
	private String Colaboradores;

	@ManyToMany
	@JoinTable(name = "proyectos_portafolios",
	       joinColumns = {
	    		   @JoinColumn(name="proyecto_id",referencedColumnName = "IdProyecto",nullable = false)
	       },
	       inverseJoinColumns = {
	    		   @JoinColumn(name="portafolio_id",referencedColumnName = "IdPortafolio",nullable = false)
	       }
	       )
	private List<Portafolio2> portafolios = new ArrayList<>();
//Explicacion min 49 clase sem9 sesion 2

	public Proyecto(String titulo_Proyect, String descripcion_Proyect, String colaboradores) {
		this.Titulo_Proyect = titulo_Proyect;
		this.Descripcion_Proyect = descripcion_Proyect;
		this.Colaboradores = colaboradores;
}
	public Proyecto() {}
	public Long getIdProyecto() {
		return IdProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		IdProyecto = idProyecto;
	}

	public String getTitulo_Proyect() {
		return Titulo_Proyect;
	}

	public void setTitulo_Proyect(String titulo_Proyect) {
		Titulo_Proyect = titulo_Proyect;
	}

	public String getDescripcion_Proyect() {
		return Descripcion_Proyect;
	}

	public void setDescripcion_Proyect(String descripcion_Proyect) {
		Descripcion_Proyect = descripcion_Proyect;
	}

	public String getColaboradores() {
		return Colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		Colaboradores = colaboradores;
	}

	public List<Portafolio2> getPortafolios() {
		return portafolios;
	}

	public void setPortafolios(List<Portafolio2> portafolios) {
		this.portafolios = portafolios;
	}
	
	
	@Override
	public String toString() {
		return "Proyecto{" + "Titulo_Proyect=" + Titulo_Proyect + ", Descripcion_Proyect=" + Descripcion_Proyect + ", Colaboradores=" + Colaboradores + '}';
	}
}
