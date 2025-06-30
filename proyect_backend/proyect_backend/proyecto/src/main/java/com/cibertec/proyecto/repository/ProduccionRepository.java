package com.cibertec.proyecto.repository;

import com.cibertec.proyecto.entity.Produccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Integer> {
    
}