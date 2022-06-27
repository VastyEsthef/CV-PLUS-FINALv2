package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.ServicioXAdviser;

@Repository
public interface ServicioXAdviserRepository extends CrudRepository<ServicioXAdviser, Long> {

}