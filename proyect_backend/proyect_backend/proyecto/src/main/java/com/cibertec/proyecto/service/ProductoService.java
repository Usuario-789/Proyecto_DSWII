package com.cibertec.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proyecto.entity.Producto;
import com.cibertec.proyecto.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Integer id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setIdProducto(id);
            return productoRepository.save(producto);
        }
        return null; // O lanza una excepción
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}