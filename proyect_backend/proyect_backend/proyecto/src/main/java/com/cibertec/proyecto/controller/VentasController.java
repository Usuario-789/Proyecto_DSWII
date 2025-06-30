package com.cibertec.proyecto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.proyecto.dto.IngresoCostoDTO;
import com.cibertec.proyecto.dto.VentaDTO;
import com.cibertec.proyecto.entity.Venta;
import com.cibertec.proyecto.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentaService ventaService;

    // Ver ventas registradas
    @GetMapping
    public List<VentaDTO> obtenerVentas() {
        return ventaService.obtenerVentas().stream()
            .map(venta -> new VentaDTO(venta.getCliente(), venta.getTotal(), venta.getFecha()))
            .collect(Collectors.toList());
    }

    // Registrar venta
    @PostMapping
    public VentaDTO registrarVenta(@RequestBody VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setCliente(ventaDTO.getCliente());
        venta.setTotal(ventaDTO.getTotal());
        venta.setFecha(ventaDTO.getFecha());

        Venta ventaGuardada = ventaService.registrarVenta(venta);

        return new VentaDTO(ventaGuardada.getCliente(), ventaGuardada.getTotal(), ventaGuardada.getFecha());
    }

    // Calcular ingresos y costos
    @GetMapping("/calcular")
    public IngresoCostoDTO calcularIngresosYCostos(@RequestParam String periodo) {
        return ventaService.calcularIngresosYCostos(periodo);
    }
}