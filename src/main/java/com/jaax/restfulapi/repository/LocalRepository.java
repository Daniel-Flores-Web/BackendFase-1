package com.jaax.restfulapi.repository;

import com.jaax.restfulapi.entity.Local;
import com.jaax.restfulapi.error.LocalNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

//    Consulta con JPQL
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findByNameWithJPQL(String name);

//    Consulta con inversion de control
    Optional<Local> findByName(String name);
    Optional<Local> findByNameIgnoreCase(String name);
//    Optional<Local> findLocalById(Long id);

}
