package com.example.examen_liverpool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direccion {
    private String estado;
    private String municipio;
    private String colonia;
}

