package com.example.examen_liverpool.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.example.examen_liverpool.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    void deleteById(Long id);
}
