package com.cibertec.proyecto.dto;

import lombok.*;

/** Datos que llegan desde el cuerpo del login POST. */
@Data                    // getters/setters
@NoArgsConstructor        // ctor vacío
@AllArgsConstructor       // ctor con todos los campos
public class AuthRequest {
    private String username;
    private String password;
}
