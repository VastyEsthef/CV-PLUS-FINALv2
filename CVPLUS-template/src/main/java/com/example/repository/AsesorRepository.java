package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Asesor;

public interface AsesorRepository extends JpaRepository<Asesor, Long> {

	@Query("SELECT count(d) FROM Asesor d  WHERE d.dni=?1")
	int verificarExistenciaAsesor(String dni);

	@Query("SELECT d FROM Asesor d  WHERE d.dni=?1")
	List<Asesor> buscarAsesor(String dni);
}
