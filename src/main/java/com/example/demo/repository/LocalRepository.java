package com.example.demo.repository;

import com.example.demo.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//permite hacer consultas personalizadas
public interface LocalRepository extends JpaRepository<Local, Long> {
    //Conslta con JPQL
    /*@Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findByNameSQL(String name);*/

    // Consulta con Inversion de control
    Optional<Local> findByName(String name);

    //Consulta ignorando mayuscula y minuscula
    Optional<Local> findBynameIgnoreCase(String name);

}
