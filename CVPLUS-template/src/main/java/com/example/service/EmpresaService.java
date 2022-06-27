package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.example.entities.Empresa;
import com.example.repository.EmpresaRepository;

@Service
public class EmpresaService{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> listarEmpresa(){
		
		List<Empresa> empresas=empresaRepository.findAll();
		
		return empresas;
	}
	
	
	public int registrarEmpresa(Empresa empresa) {
		int existeEmpresa=empresaRepository.verificarExistenciaEmpresa(empresa.getRuc());
		
		if(existeEmpresa==0)
			empresaRepository.save(empresa);
		
		return existeEmpresa;
	}
	
	
	public List<Empresa> buscarEmpresaporRuc(String Ruc){
		
		List<Empresa> empresas=empresaRepository.buscarEmpresaPorRuc(Ruc);
		
		
		return empresas;
	}

}
