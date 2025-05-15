package com.example.examen_liverpool.infrastructure.client;

import lombok.Data;

@Data
public class SepomexResponse {
    private String cp;
    private String asentamiento;
    private String tipo_asentamiento;
    private String municipio;
    private String estado;
    private String ciudad;
    private String pais;
}
