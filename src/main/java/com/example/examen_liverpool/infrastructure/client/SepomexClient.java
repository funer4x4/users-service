package com.example.examen_liverpool.infrastructure.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sepomexClient", url = "https://api.copomex.com/query")
public interface SepomexClient {

    @GetMapping("/info_cp/{cp}")
    List<SepomexEntry> buscarPorCodigoPostal(
        @PathVariable("cp") String codigoPostal,
        @RequestParam("token") String token
    );
}
