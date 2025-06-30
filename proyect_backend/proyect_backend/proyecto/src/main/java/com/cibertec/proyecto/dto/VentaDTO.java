package com.cibertec.proyecto.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class VentaDTO {
    private String cliente;
    private BigDecimal total;
    private Date fecha;

    // Constructor
    public VentaDTO(String cliente, BigDecimal total, Date fecha) {
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}