package com.example.examen_liverpool.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.examen_liverpool.domain.model.Direccion;
import com.example.examen_liverpool.domain.model.Usuario;
import com.example.examen_liverpool.domain.port.out.ConsultaDireccionPort;
import com.example.examen_liverpool.domain.port.out.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepositoryPort usuarioRepo;
    private final ConsultaDireccionPort direccionPort;

    public Usuario crearUsuario(Usuario usuario) {
        log.info("Creando usuario con CP: {}", usuario.getCodigoPostal());

        Direccion direccion = direccionPort.obtenerDireccionPorCP(usuario.getCodigoPostal());

        if (direccion == null) {
            log.error("No se encontró dirección para el CP: {}", usuario.getCodigoPostal());
            throw new IllegalArgumentException("Código postal no válido o sin resultados");
        }

        usuario.setEstado(direccion.getEstado());
        usuario.setMunicipio(direccion.getMunicipio());
        usuario.setColonia(direccion.getColonia());

        Usuario guardado = usuarioRepo.save(usuario);

        log.info("Usuario creado: {}", guardado);
        return guardado;
    }

    public List<Usuario> listar() {
        log.info("Listando todos los usuarios");
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        log.info("Buscando usuario con ID: {}", id);
        return usuarioRepo.findById(id);
    }

    public void eliminar(Long id) {
        log.info("Eliminando usuario con ID: {}", id);
        usuarioRepo.deleteById(id);
    }
}
