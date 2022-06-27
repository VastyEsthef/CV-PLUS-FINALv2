package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Rubro;
import com.example.repository.RubroRepository;

@Service
public class RubroService {

	@Autowired
	private RubroRepository rubroRepository;

	public List<Rubro> listarRubros() {
		return rubroRepository.findAll();
	}
}
