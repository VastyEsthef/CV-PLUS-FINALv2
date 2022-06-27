package com.example.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "advisers")
public class Adviser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdviser;

	@Column(name = "First_NameAs", length = 50, nullable = false)
	private String firstName;

	@Column(name = "Last_NameAs", length = 50, nullable = false)
	private String lastName;

	@Column(name = "Email_As", length = 50, nullable = false)
	private String email;

	@Column(name = "Dni_As", nullable = false)
	private Long dni_As;

	@Column(name = "Num_Cel_As", nullable = false)
	private Long telefono;

	@Column(name = "Contrasenia", length = 50, nullable = false)
	private String contrasenia;

	@OneToMany(mappedBy = "adviser")
	Set<ServicioXAdviser> serviciosAdviser;

	public Long getIdAdviser() {
		return idAdviser;
	}

	public void setIdAdviser(Long idAdviser) {
		this.idAdviser = idAdviser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDni() {
		return dni_As;
	}

	public void setDni(Long dni_As) {
		this.dni_As = dni_As;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Set<ServicioXAdviser> getServiciosAdviser() {
		return serviciosAdviser;
	}

	public void setServiciosAdviser(Set<ServicioXAdviser> serviciosAdviser) {
		this.serviciosAdviser = serviciosAdviser;
	}
	
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
}
