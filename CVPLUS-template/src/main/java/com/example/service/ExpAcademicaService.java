package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entities.ExpAcademica;
import com.example.repository.ExpAcademicaRepository;

	public class ExpAcademicaService {

		@Autowired
		private ExpAcademicaRepository expAcademicaRepository;
		
		@Transactional
		public void insertar(ExpAcademica expAcademica) {
		
			
			expAcademicaRepository.save(expAcademica);
	     }


		public void eliminar(Long idExpAcademica) {
			// TODO Auto-generated method stub
			expAcademicaRepository.deleteById(idExpAcademica);
			
		}
	}
