package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum,Long>{

	
}
