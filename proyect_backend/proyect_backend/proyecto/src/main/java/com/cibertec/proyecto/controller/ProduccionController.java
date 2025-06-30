package com.cibertec.proyecto.controller;

import com.cibertec.proyecto.dto.ProduccionDTO;
import com.cibertec.proyecto.entity.Produccion;
import com.cibertec.proyecto.entity.Producto;
import com.cibertec.proyecto.service.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produccion")
public class ProduccionController {
    @Autowired
    private ProduccionService produccionService;

    // Mostrar el registro de producción
    @GetMapping
    public List<ProduccionDTO> obtenerProducciones() {
        return produccionService.obtenerProducciones().stream()
            .map(produccion -> new ProduccionDTO(produccion.getProductoGenerado().getNombre(), produccion.getCantidad(), produccion.getFecha(), produccion.getObservaciones()))
            .collect(Collectors.toList());
    }

    // Registrar una nueva producción
    @PostMapping
    public ProduccionDTO registrarProduccion(@RequestBody ProduccionDTO produccionDTO) {
        Producto producto = new Producto();  // Debes recuperar el producto correspondiente desde la base de datos
        Produccion produccion = new Produccion();
        produccion.setProductoGenerado(producto);
        produccion.setCantidad(produccionDTO.getCantidad());
        produccion.setFecha(produccionDTO.getFecha());
        produccion.setObservaciones(produccionDTO.getObservaciones());
        
        Produccion produccionGuardada = produccionService.registrarProduccion(produccion);
        return new ProduccionDTO(produccionGuardada.getProductoGenerado().getNombre(), produccionGuardada.getCantidad(), produccionGuardada.getFecha(), produccionGuardada.getObservaciones());
    }

    // Actualizar producción
    @PutMapping("/{id}")
    public ProduccionDTO actualizarProduccion(@PathVariable Integer id, @RequestBody ProduccionDTO produccionDTO) {
        Producto producto = new Producto();  // Debes recuperar el producto correspondiente desde la base de datos
        Produccion produccion = new Produccion();
        produccion.setProductoGenerado(producto);
        produccion.setCantidad(produccionDTO.getCantidad());
        produccion.setFecha(produccionDTO.getFecha());
        produccion.setObservaciones(produccionDTO.getObservaciones());

        Produccion produccionActualizada = produccionService.actualizarProduccion(id, produccion);
        return new ProduccionDTO(produccionActualizada.getProductoGenerado().getNombre(), produccionActualizada.getCantidad(), produccionActualizada.getFecha(), produccionActualizada.getObservaciones());
    }

    // Eliminar producción
    @DeleteMapping("/{id}")
    public void eliminarProduccion(@PathVariable Integer id) {
        produccionService.eliminarProduccion(id);
    }
}