package com.cibertec.proyecto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.proyecto.dto.ProductoDTO;
import com.cibertec.proyecto.entity.Producto;
import com.cibertec.proyecto.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    // Listar productos
    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.listarProductos().stream()
            .map(producto -> new ProductoDTO(producto.getNombre(), producto.getTipo(), producto.getStock(), producto.getUnidadMedida(), producto.getPrecioUnitario()))
            .collect(Collectors.toList());
    }

    // Agregar nuevo producto
    @PostMapping
    public ProductoDTO agregarProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setTipo(productoDTO.getTipo());
        producto.setStock(productoDTO.getStock());
        producto.setUnidadMedida(productoDTO.getUnidadMedida());
        producto.setPrecioUnitario(productoDTO.getPrecioUnitario());

        Producto productoGuardado = productoService.agregarProducto(producto);
        return new ProductoDTO(productoGuardado.getNombre(), productoGuardado.getTipo(), productoGuardado.getStock(), productoGuardado.getUnidadMedida(), productoGuardado.getPrecioUnitario());
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setTipo(productoDTO.getTipo());
        producto.setStock(productoDTO.getStock());
        producto.setUnidadMedida(productoDTO.getUnidadMedida());
        producto.setPrecioUnitario(productoDTO.getPrecioUnitario());

        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        return new ProductoDTO(productoActualizado.getNombre(), productoActualizado.getTipo(), productoActualizado.getStock(), productoActualizado.getUnidadMedida(), productoActualizado.getPrecioUnitario());
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }
}