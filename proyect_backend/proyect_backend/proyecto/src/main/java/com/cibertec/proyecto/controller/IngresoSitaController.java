package com.cibertec.proyecto.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cibertec.proyecto.dto.ProductoDTO;
import com.cibertec.proyecto.entity.Producto;
import com.cibertec.proyecto.service.IngresoSitaService;

@RestController
@RequestMapping("/api/ingresoSita")
public class IngresoSitaController {

    @Autowired
    private IngresoSitaService ingresoSitaService;

    // Actualizar producto y cantidad
    @PutMapping("/actualizar/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setTipo(productoDTO.getTipo());
        producto.setStock(productoDTO.getStock());
        producto.setUnidadMedida(productoDTO.getUnidadMedida());
        producto.setPrecioUnitario(productoDTO.getPrecioUnitario());

        Producto productoActualizado = ingresoSitaService.actualizarProducto(id, producto);
        return new ProductoDTO(productoActualizado.getNombre(), productoActualizado.getTipo(), productoActualizado.getStock(), productoActualizado.getUnidadMedida(), productoActualizado.getPrecioUnitario());
    }

    // Eliminar registro
    @DeleteMapping("/eliminar/{id}")
    public void eliminarRegistro(@PathVariable Integer id) {
        ingresoSitaService.eliminarRegistro(id);
    }
}

