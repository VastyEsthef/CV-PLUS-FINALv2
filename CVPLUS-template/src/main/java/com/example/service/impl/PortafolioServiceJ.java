package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Portafolio2;
import com.example.repository.PortafolioRepository2;



@Service
public class PortafolioServiceJ implements com.example.service.PortafolioService2{

	@Autowired
	private PortafolioRepository2 portafolioRepository2;
	

	@Override
	public List<Portafolio2> getAll() throws Exception {
		// TODO Auto-generated method stub
		return portafolioRepository2.findAll();
	}

	@Override
	public Portafolio2 getOneById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long create(Portafolio2 entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, Portafolio2 entity) throws Exception {
		
		
	}

	@Override
	public void delete(Long id) throws Exception {
		portafolioRepository2.deleteById(id);
		
	}

	@Override
	public Portafolio2 saveOrUpdate(Portafolio2 entity) throws Exception {
		// TODO Auto-generated method stub
		return portafolioRepository2.save(entity);
	}

	@Override
	public Optional<Portafolio2> getOne(Long id) throws Exception {
		// TODO Auto-generated method stub
		return portafolioRepository2.findById(id);
	}

	@Override
	public List<Portafolio2> getPortafolioById(Long id) throws Exception {
		
		return portafolioRepository2.findByIdPortafolio(id);
	}



	@Override
	public List<Portafolio2> getPortafolioByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return portafolioRepository2.findByTitleContaining(nombre);
	}

    
	public List<Portafolio2>getAllPortafolios(){
		return portafolioRepository2.findAllSortByName();
		
	}
	
	

	
	
}