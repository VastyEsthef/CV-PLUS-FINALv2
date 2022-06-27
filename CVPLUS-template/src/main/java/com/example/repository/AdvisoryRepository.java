package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Advisory;

@Repository
public interface AdvisoryRepository extends CrudRepository<Advisory, Long> {

}