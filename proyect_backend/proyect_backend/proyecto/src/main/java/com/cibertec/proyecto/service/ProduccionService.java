package com.cibertec.proyecto.service;

import com.cibertec.proyecto.entity.Produccion;
import com.cibertec.proyecto.repository.ProduccionRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProduccionService {
    @Autowired
    private ProduccionRepository produccionRepository;

    // Obtener todas las producciones
    public List<Produccion> obtenerProducciones() {
        return produccionRepository.findAll();
    }

    // Registrar nueva producción
    public Produccion registrarProduccion(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    // Actualizar producción existente
    public Produccion actualizarProduccion(Integer id, Produccion produccion) {
        if (produccionRepository.existsById(id)) {
            produccion.setIdProduccion(id);
            return produccionRepository.save(produccion);
        }
        return null;
    }

    // Eliminar producción
    public void eliminarProduccion(Integer id) {
        produccionRepository.deleteById(id);
    }
}