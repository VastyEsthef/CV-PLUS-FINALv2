package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "asesores")
public class Asesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Debe ingresar nombre del asesor*")
	@Column(name = "nombre_completo", nullable = false, length = 45)
	private String nombreCompleto;

	@Size(min = 8, max = 8, message = "El numero de DNI debe tener 8 digitos")
	@NotEmpty(message = "Debe ingresar su DNI*")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Past(message = "Fecha de licenciamiento no correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_licenciado", nullable = false)
	private Date fechaLicenciado;

	@Max(80)
	@Min(21)
	@Column(name = "edad", nullable = false)
	private int edad;

	@Max(70)
	@Min(0)
	@Column(name = "tiempo_experiencia", nullable = false)
	private int tiempoExperiencia;

	@Transient
	private double tarifaHora;

	// El asesor tiene que tener un rubro
	@ManyToOne
	@JoinColumn(name = "rubro_id", nullable = false)
	private Rubro rubro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaLicenciado() {
		return fechaLicenciado;
	}

	public void setFechaLicenciado(Date fechaLicenciado) {
		this.fechaLicenciado = fechaLicenciado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getTiempoExperiencia() {
		return tiempoExperiencia;
	}

	public void setTiempoExperiencia(int tiempoExperiencia) {
		this.tiempoExperiencia = tiempoExperiencia;
	}

	public double getTarifaHora() {
		return tarifaHora;
	}

	public void setTarifaHora(double tarifaHora) {
		this.tarifaHora = tarifaHora;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

}
