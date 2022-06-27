package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entities.Curriculum;
import com.example.repository.CurriculumRepository;


public class CurriculumService {
	
	
	@Autowired
	private CurriculumRepository curriculumRepository;
	
	
	public List<Curriculum> listarExpLaboral() throws Exception{
		
		
		List<Curriculum> curriculums=curriculumRepository.findAll();
		
		return curriculums;
	}

	@Transactional
	public void registrarExpLaboral(Curriculum curriculum) {
	
		curriculumRepository.save(curriculum);

}

	public Optional<Curriculum> getOne(Long idCurriculum) throws Exception {
		return curriculumRepository.findById(idCurriculum);
	}

	public void eliminar(Long idCurriculum) {
		// TODO Auto-generated method stub
		curriculumRepository.deleteById(idCurriculum);
		
	}

}
