package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.entities.ServicioXAdviser;
import com.example.repository.ServicioXAdviserRepository;

@Service
public class ServicioXAdviserService {

    @Autowired
    private ServicioXAdviserRepository service_adviserRepository;


    public List<ServicioXAdviser> getAllSxA() {
        return (List<ServicioXAdviser>) service_adviserRepository.findAll();
    }

    public void saveSxA (ServicioXAdviser sxa) {

        service_adviserRepository.save(sxa);
    }


    public ServicioXAdviser FindById (Long id) {

        return service_adviserRepository.findById(id).orElse(null);
    }

    public void DeleteSxA (Long id) {

        service_adviserRepository.deleteById(id);
    }

    public int validarHora(Date d1, Date d2) {

        int result = 0;

        if (d2.getTime() - d1.getTime() >= 7200000 && d2.getTime() - d1.getTime() <= 14400000 ) {
            result=1;
        }
        return result;
    }



}