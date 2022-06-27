package com.example.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.entities.Portafolio2;
import com.example.repository.PortafolioRepository2;



@Service
public class PortafolioService1{


    private PortafolioRepository2 portafolioRepository;



    public PortafolioService1(PortafolioRepository2 portafolioRepository) {
        this.portafolioRepository=portafolioRepository;

    }


    public List<Portafolio2> getAllPortafolios(){
        return portafolioRepository.findAll();

    }



    public Portafolio2 getSPortafolioById(Long IdPortafolio) {
        return portafolioRepository.findById(IdPortafolio).get();

    }

public List<Portafolio2>buscarPortafolioPorNombre(String NombrePortafolio){

        List<Portafolio2> portafolios=portafolioRepository.buscarPortafolio(NombrePortafolio);

        return portafolios;
    }





}