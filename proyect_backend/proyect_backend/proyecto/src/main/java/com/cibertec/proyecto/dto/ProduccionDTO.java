package com.cibertec.proyecto.dto;

import java.sql.Date;



public class ProduccionDTO {
    private String productoGenerado;
    private Integer cantidad;
    private Date fecha;
    private String observaciones;

    // Constructor
    public ProduccionDTO(String productoGenerado, Integer cantidad, Date fecha, String observaciones) {
        this.productoGenerado = productoGenerado;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public String getProductoGenerado() {
        return productoGenerado;
    }

    public void setProductoGenerado(String productoGenerado) {
        this.productoGenerado = productoGenerado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}