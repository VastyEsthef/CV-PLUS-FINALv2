package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresas" )
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="direccion",nullable=false)
	private String direccion;
	@Column(name="numero",nullable=false)
	private String numero;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="ruc",nullable=false)
	private String ruc;
	@Column(name="contrasenia",nullable=false)
	private String contrasenia;
	
	@ManyToMany
	@JoinTable(name="valoracion_portafolio",
		joinColumns= {
				@JoinColumn(name="empresa_id",referencedColumnName="id",nullable=false)			
		},
		inverseJoinColumns= {
				@JoinColumn(name="portafolio_id",referencedColumnName="id",nullable=false)
		}
	)
	private List<Portafolio> portafolios=new ArrayList<>();

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<Portafolio> getPortafolios() {
		return portafolios;
	}

	public void setPortafolios(List<Portafolio> portafolios) {
		this.portafolios = portafolios;
	}
	
}
