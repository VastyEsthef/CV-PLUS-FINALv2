package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{



    @Query("FROM Proyecto pr WHERE pr.Titulo_Proyect LIKE :titulo OR pr.Descripcion_Proyect LIKE :titulo")
    public List<Proyecto> findByNameContaining(@Param("titulo") String titulo);


    @Query("SELECT pr FROM Proyecto pr  WHERE pr.Titulo_Proyect=?1")
    public List<Proyecto> buscarProyecto(String Titulo_Proyect);







}