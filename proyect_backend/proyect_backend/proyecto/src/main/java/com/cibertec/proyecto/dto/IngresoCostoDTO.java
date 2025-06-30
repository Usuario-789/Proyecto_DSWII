package com.cibertec.proyecto.dto;

import java.math.BigDecimal;

public class IngresoCostoDTO {
    private BigDecimal ingresos;
    private BigDecimal costos;

    // Constructor
    public IngresoCostoDTO(BigDecimal ingresos, BigDecimal costos) {
        this.ingresos = ingresos;
        this.costos = costos;
    }

    // Getters y Setters
    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getCostos() {
        return costos;
    }

    public void setCostos(BigDecimal costos) {
        this.costos = costos;
    }
}

