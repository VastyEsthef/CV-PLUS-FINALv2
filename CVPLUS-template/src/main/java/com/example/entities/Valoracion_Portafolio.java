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
@Table(name="Valoracion_Portafolios")
public class Valoracion_Portafolio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdRate;
	
	@Column(name = "Valoracion_Porta", length = 5, nullable = false)
	private String Valoracion_Porta;
	
	@Column(name = "Comentario_Porta", length = 200, nullable = false)
	private String Comentario_Porta;
	

	@ManyToOne
	@JoinColumn(name="IdPortafolio",nullable=false)
	private Portafolio portafolio;
	
	@ManyToOne
	@JoinColumn(name="IdEmpresa",nullable=false)
	private Empresa empresa;

	public Long getIdRate() {
		return IdRate;
	}

	public void setIdRate(Long idRate) {
		IdRate = idRate;
	}

	public String getValoracion_Porta() {
		return Valoracion_Porta;
	}

	public void setValoracion_Porta(String valoracion_Porta) {
		Valoracion_Porta = valoracion_Porta;
	}

	public String getComentario_Porta() {
		return Comentario_Porta;
	}

	public void setComentario_Porta(String comentario_Porta) {
		Comentario_Porta = comentario_Porta;
	}

	public Portafolio getPortafolio() {
		return portafolio;
	}

	public void setPortafolio(Portafolio portafolio) {
		this.portafolio = portafolio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}