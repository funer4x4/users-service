package com.example.examen_liverpool.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UsuarioEntity {
    @Id @GeneratedValue
    private Long id;
    private String nombre, apellidoPaterno, apellidoMaterno, correo;
    private String codigoPostal, estado, municipio, colonia;
}

