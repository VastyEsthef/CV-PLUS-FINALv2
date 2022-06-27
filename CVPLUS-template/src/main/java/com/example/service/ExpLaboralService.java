package com.example.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entities.ExpLaboral;

import com.example.repository.ExpLaboralRepository;

		public class ExpLaboralService {

			@Autowired
			private ExpLaboralRepository expLaboralRepository;
			
			
			public List<ExpLaboral> listarExpLaboral() throws Exception{
				
				
				List<ExpLaboral> expLaborales=expLaboralRepository.findAll();
				
				return expLaborales;
			}
		
			@Transactional
			public void registrarExpLaboral(ExpLaboral expLaboral) {
			
				expLaboralRepository.save(expLaboral);
	
		}

			public Optional<ExpLaboral> getOne(Long idExpLaboral) throws Exception {
				return expLaboralRepository.findById(idExpLaboral);
			}

			public void eliminar(Long idExpLaboral) {
				// TODO Auto-generated method stub
				expLaboralRepository.deleteById(idExpLaboral);
				
			}
		}
