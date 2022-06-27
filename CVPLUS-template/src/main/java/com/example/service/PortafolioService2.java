package com.example.service;

import java.util.List;

import com.example.entities.Portafolio2;

public interface PortafolioService2 extends CrudService<Portafolio2, Long>{

    List<Portafolio2>getPortafolioById(Long id)throws Exception;

    List<Portafolio2>getPortafolioByName(String nombre)throws Exception;

}