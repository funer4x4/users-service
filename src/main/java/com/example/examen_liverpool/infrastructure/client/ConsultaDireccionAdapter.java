package com.example.examen_liverpool.infrastructure.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.examen_liverpool.domain.model.Direccion;
import com.example.examen_liverpool.domain.port.out.ConsultaDireccionPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsultaDireccionAdapter implements ConsultaDireccionPort {

    private final SepomexClient sepomexClient;

    @Value("${copomex.token}")
    private String token;

    @Override
    public Direccion obtenerDireccionPorCP(String codigoPostal) {
        log.info("Consultando dirección con código postal: {}", codigoPostal);

        List<SepomexEntry> resultados = sepomexClient.buscarPorCodigoPostal(codigoPostal, token);

        log.debug("Respuesta cruda de COPOMEX: {}", resultados);

        if (resultados.isEmpty()) {
            log.warn("No se encontró información para el CP: {}", codigoPostal);
            return null;
        }

        SepomexResponse primera = resultados.get(0).getResponse();

        Direccion direccion = new Direccion(
            primera.getEstado(),
            primera.getMunicipio(),
            primera.getAsentamiento()
        );

        log.info("Dirección obtenida: {}", direccion);
        return direccion;
    }
}