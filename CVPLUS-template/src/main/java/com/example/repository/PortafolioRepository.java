package com.example.repository;

import java.util.List;

import com.example.entities.Portafolio;
import com.example.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PortafolioRepository extends JpaRepository<Portafolio,Long>{
	

	@Query("FROM Portafolio p ORDER BY nombre ASC")
	List<Portafolio> findAllSortByName();
	@Query("FROM Portafolio p ORDER BY id ASC")
	List<Portafolio> findAllSortById();
	@Query("FROM Portafolio p ORDER BY valoracion DESC")
	List<Portafolio> findAllSortByValoracion();
	
	@Query("SELECT count(p) FROM Portafolio p  WHERE p.valoracion=?1")
	List<Portafolio> buscarValoracion(String valoracion);

}