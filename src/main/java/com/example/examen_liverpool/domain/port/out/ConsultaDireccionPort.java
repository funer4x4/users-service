package com.example.examen_liverpool.domain.port.out;

import com.example.examen_liverpool.domain.model.Direccion;

public interface ConsultaDireccionPort {
    Direccion obtenerDireccionPorCP(String codigoPostal);
}
