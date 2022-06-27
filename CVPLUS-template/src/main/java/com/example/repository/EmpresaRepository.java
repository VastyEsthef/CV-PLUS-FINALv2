package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT count(e) FROM Empresa e  WHERE e.ruc=?1")
	int verificarExistenciaEmpresa(String ruc);
	
	@Query("SELECT e FROM Empresa e  WHERE e.ruc=?1")
	List<Empresa> buscarEmpresaPorRuc(String ruc);
}
