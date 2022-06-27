package com.example.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.entities.Proyecto;
import com.example.repository.ProyectoRepository;


@Service
public class ProyectoService{


    private ProyectoRepository proyectoRepository;



    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository=proyectoRepository;

    }


    public List<Proyecto> getAllProyectos(){
        return proyectoRepository.findAll();

    }


    public Proyecto saveProyecto(Proyecto proyecto) {

        return proyectoRepository.save(proyecto);

    }


    public Proyecto getProyectoById(Long IdProyecto) {
        return proyectoRepository.findById(IdProyecto).get();

    }


    public Proyecto updateProyecto(Proyecto proyecto) {

        return proyectoRepository.save(proyecto);

    }


    public void deleteProyectoById(Long IdProyecto) {

        proyectoRepository.deleteById(IdProyecto);

    }


    public List<Proyecto> getStudentByName(String titulo) {
        return proyectoRepository.findByNameContaining(titulo);
    }

    public List<Proyecto>buscarProyectoPorNombre(String Titulo_Proyect){

        List<Proyecto> proyectos=proyectoRepository.buscarProyecto(Titulo_Proyect);

        return proyectos;
    }





}