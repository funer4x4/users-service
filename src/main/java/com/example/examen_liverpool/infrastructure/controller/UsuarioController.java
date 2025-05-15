package com.example.examen_liverpool.infrastructure.controller;

import com.example.examen_liverpool.domain.model.Usuario;
import com.example.examen_liverpool.application.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Tag(name = "Users API", description = "CRUD operations for Users")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @Operation(summary = "Crear un nuevo usuario", responses = {
        @ApiResponse(responseCode = "200", description = "Usuario creado correctamente",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content)
    })
    @PostMapping
    public Usuario crear(@Valid @RequestBody Usuario usuario) {
        log.info("Solicitud para crear usuario");
        return usuarioService.crearUsuario(usuario);
    }

    @Operation(summary = "Listar todos los usuarios", responses = {
        @ApiResponse(responseCode = "200", description = "Lista de usuarios",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class)))
    })
    @GetMapping
    public List<Usuario> listar() {
        log.info("Solicitud para obtener todos los usuarios");
        return usuarioService.listar();
    }

    @Operation(summary = "Obtener un usuario por ID", responses = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        log.info("Solicitud para obtener usuario por identificador");
        return usuarioService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un usuario por ID", responses = {
        @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        log.info("Solicitud para obtener eliminar usuario");
        usuarioService.eliminar(id);
    }
}
