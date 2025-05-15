package com.example.examen_liverpool.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.examen_liverpool.domain.model.Usuario;
import com.example.examen_liverpool.domain.port.out.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioJpaAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepo;

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapToEntity(usuario);
        return mapToDomain(jpaRepo.save(entity));
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepo.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepo.findById(id).map(this::mapToDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // 👇 Métodos de mapeo
    private Usuario mapToDomain(UsuarioEntity entity) {
        Usuario usuario = new Usuario();
        usuario.setId(entity.getId());
        usuario.setNombre(entity.getNombre());
        usuario.setApellidoPaterno(entity.getApellidoPaterno());
        usuario.setApellidoMaterno(entity.getApellidoMaterno());
        usuario.setCorreo(entity.getCorreo());
        usuario.setCodigoPostal(entity.getCodigoPostal());
        usuario.setEstado(entity.getEstado());
        usuario.setMunicipio(entity.getMunicipio());
        usuario.setColonia(entity.getColonia());
        return usuario;
    }

    private UsuarioEntity mapToEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setApellidoPaterno(usuario.getApellidoPaterno());
        entity.setApellidoMaterno(usuario.getApellidoMaterno());
        entity.setCorreo(usuario.getCorreo());
        entity.setCodigoPostal(usuario.getCodigoPostal());
        entity.setEstado(usuario.getEstado());
        entity.setMunicipio(usuario.getMunicipio());
        entity.setColonia(usuario.getColonia());
        return entity;
    }
}
