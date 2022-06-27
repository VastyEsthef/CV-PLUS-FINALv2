package com.example.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {

     @Query("FROM Servicio sa ORDER BY Estado ASC")
     public List<Servicio> findAllAdvisorSortByType();



}