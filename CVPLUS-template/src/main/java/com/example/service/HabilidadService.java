package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.entities.Habilidad;
import com.example.repository.HabilidadRepository;

public class HabilidadService {
	
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	
	public List<Habilidad> listarHabilidad() throws Exception{
		
		
		List<Habilidad> habilidades=habilidadRepository.findAll();
		
		return habilidades;
	}
	
	@Transactional
	public void registrarHabilidad(Habilidad habilidad) {
	
		habilidadRepository.save(habilidad);
	
	}
	
	public Optional<Habilidad> getOne(Long idHabilidad) throws Exception {
		return habilidadRepository.findById(idHabilidad);
	}
	
	public void eliminar(Long idHabilidad) {
		// TODO Auto-generated method stub
		habilidadRepository.deleteById(idHabilidad);
		
	}

}