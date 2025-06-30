package com.cibertec.proyecto.repository;

import com.cibertec.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}