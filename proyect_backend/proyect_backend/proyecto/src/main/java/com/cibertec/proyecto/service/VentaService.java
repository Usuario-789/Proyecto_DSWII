package com.cibertec.proyecto.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.proyecto.dto.IngresoCostoDTO;
import com.cibertec.proyecto.entity.Venta;
import com.cibertec.proyecto.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    public Venta registrarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public IngresoCostoDTO calcularIngresosYCostos(String periodo) {
        // Implementa la lógica para calcular los ingresos y costos
        BigDecimal ingresos = BigDecimal.valueOf(1000); // Ejemplo: calcular ingresos
        BigDecimal costos = BigDecimal.valueOf(500);    // Ejemplo: calcular costos

        return new IngresoCostoDTO(ingresos, costos);
    }
}