package com.ada.backendfinalproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Optional<Usuario> findByUsuario(String usuario);

	Optional<Usuario> findByUsuarioAndContraseña(String usuario, String contraseña);

}
