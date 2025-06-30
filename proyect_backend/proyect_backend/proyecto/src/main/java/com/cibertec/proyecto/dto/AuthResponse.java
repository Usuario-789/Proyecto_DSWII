package com.cibertec.proyecto.dto;

import lombok.*;

/** Respuesta simple tras un login exitoso. */
@Data
@AllArgsConstructor
public class AuthResponse {
    private String mensaje;
}
