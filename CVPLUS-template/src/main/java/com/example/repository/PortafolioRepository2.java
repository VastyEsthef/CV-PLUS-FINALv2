package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.entities.Portafolio2;

public interface PortafolioRepository2 extends JpaRepository<Portafolio2, Long> {

    @Query("FROM Portafolio2 p WHERE p.IdPortafolio like :id")
    List<Portafolio2>findByIdPortafolio(@Param("id")Long IdPortafolio);

    @Query("FROM Portafolio2 p WHERE p.NombrePortafolio like :nombre")
    List<Portafolio2> findByTitleContaining(@Param("nombre") String nombre);

    @Query("FROM Portafolio2 p WHERE p.NombrePortafolio like :NombrePortafolio")
    List<Portafolio2> buscarPortafolio(@Param("NombrePortafolio") String NombrePortafolio);

    //@Query("SELECT p FROM Portafolio p  WHERE p.NombrePortafolio=?1")
    //public List<Portafolio> buscarPortafolio(String NombrePortafolio);




    @Query("FROM Portafolio2 p ORDER BY NombrePortafolio ASC")
    public List<Portafolio2>findAllSortByName();






}