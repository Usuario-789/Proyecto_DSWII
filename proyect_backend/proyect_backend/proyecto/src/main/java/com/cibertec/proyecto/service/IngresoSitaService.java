package com.cibertec.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proyecto.entity.Producto;
import com.cibertec.proyecto.repository.ProductoRepository;

@Service
public class IngresoSitaService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto actualizarProducto(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setIdProducto(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    public void eliminarRegistro(Integer id) {
        productoRepository.deleteById(id);
    }
}
