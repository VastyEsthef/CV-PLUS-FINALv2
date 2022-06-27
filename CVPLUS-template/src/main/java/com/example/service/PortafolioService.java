package com.example.service;

import java.util.List;

import com.example.entities.Portafolio;
import com.example.repository.PortafolioRepository;
import com.zaxxer.hikari.SQLExceptionOverride.Override;

import org.springframework.stereotype.Service;

@Service
public class PortafolioService {
	
	private PortafolioRepository portafolioRepository;
	
	public PortafolioService(PortafolioRepository portafolioRepository) {
		this.portafolioRepository=portafolioRepository;
	}
	
	public List<Portafolio> getAllPortafolios(){
		return portafolioRepository.findAllSortByName();
	}
	
	public List<Portafolio> getAllPortafoliosById(){
		return portafolioRepository.findAllSortById();
	}
	
	public List<Portafolio> getAllPortafoliosByValoracion(){
		return portafolioRepository.findAllSortByValoracion();
	}
	
	public List<Portafolio> getAllPorta(){
		return portafolioRepository.findAll();
	}
	
	public List<Portafolio> buscarPortafolioByValoracion(String valoracion){
		List<Portafolio> portafolios=portafolioRepository.buscarValoracion(valoracion);
		return portafolios;
	}
	
	
	
	public Portafolio savePortafolio(Portafolio portafolio) {
		return portafolioRepository.save(portafolio);
	}
	
	public Portafolio getPortafolioById(Long id) {
		return portafolioRepository.findById(id).get();
	}
	
	public Portafolio updatePortafolio(Portafolio portafolio) {
		return portafolioRepository.save(portafolio);
	}
	
	public void update(Long id,Portafolio entity) {
		Portafolio currentPortafolio= getPortafolioById(id);
		currentPortafolio.setComentario(entity.getComentario());
		currentPortafolio.setValoracion(entity.getValoracion());
		portafolioRepository.save(currentPortafolio);
		
	}
	
	
	
}