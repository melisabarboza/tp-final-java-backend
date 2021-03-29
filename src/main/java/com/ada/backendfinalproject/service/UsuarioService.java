package com.ada.backendfinalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.repository.UsuarioRepository;
import com.ada.backendfinalproject.solicitudes.FormUsuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario addNew(FormUsuario solicitud) {

		Usuario usuario = new Usuario(0, solicitud.getUsuario(), solicitud.getContraseña(), solicitud.getRol());

		usuarioRepository.save(usuario);
		return usuario;

	}
}
