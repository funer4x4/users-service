package com.example.examen_liverpool.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 100, message = "El apellido paterno no puede tener más de 100 caracteres")
    private String apellidoPaterno;

    @Size(max = 100, message = "El apellido materno no puede tener más de 100 caracteres")
    private String apellidoMaterno;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;
    
    @NotBlank(message = "El código postal es obligatorio")
    @Pattern(regexp = "\\d{5}", message = "El código postal debe tener exactamente 5 dígitos")
    private String codigoPostal;

    private String estado;
    private String municipio;
    private String colonia;
}
