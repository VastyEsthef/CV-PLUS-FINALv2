package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.example.entities.Adviser;
import com.example.repository.AdviserRepository;

@Service
public class AdviserService{
	@Autowired
	private AdviserRepository adviserRepository;
	
	public List<Adviser> listarAdviser(){
		
		List<Adviser> advisers=adviserRepository.findAll();
		
		return  advisers;
	}
	
	
	public int registrarAdvisers(Adviser adviser) {
		int existeAdviser=adviserRepository.verificarExistenciaAdviser(adviser.getDni_As());
		
		if(existeAdviser==0)
			adviserRepository.save(adviser);
		
		return existeAdviser;
	}
	
	
	public List<Adviser> buscarAdviserPorDni(String Dni_As){
		
		List<Adviser> advisers=adviserRepository.buscarAdviserPorDNI(Dni_As);
		
		
		return advisers;
	}

}
