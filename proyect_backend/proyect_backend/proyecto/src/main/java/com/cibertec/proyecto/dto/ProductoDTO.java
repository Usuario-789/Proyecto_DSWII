package com.cibertec.proyecto.dto;

import java.math.BigDecimal;

public class ProductoDTO {
    private String nombre;
    private String tipo;
    private Integer stock;
    private String unidadMedida;
    private BigDecimal precioUnitario;

    // Constructor
    public ProductoDTO(String nombre, String tipo, Integer stock, String unidadMedida, BigDecimal precioUnitario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
