package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.repository.RepresentanteRepository;
import com.ada.backendfinalproject.solicitudes.FormRepresentante;

@Service
public class RepresentanteService {

	@Autowired
	RepresentanteRepository representanteRepository;

	@Autowired
	UsuarioService usuarioService;

	public Representante addNew(FormRepresentante solicitud) {
		// Validar que la organizacion este aprobada
		Optional<Usuario> usuario = usuarioService.getUsuarioByUsuario(solicitud.getUsuario());
		Representante representante = new Representante(usuario.get(), solicitud.getIdOrganizacion(),
				solicitud.getNombreApellido(), solicitud.getDni(), solicitud.getCargo(), solicitud.getEmail());

		representanteRepository.save(representante);
		return representante;

	}

	public Representante reemplazarInformacion(FormRepresentante solicitud) {
		Optional<Usuario> usuario = usuarioService.getUsuarioByUsuario(solicitud.getUsuario());
		Optional<Representante> optRepresentante = representanteRepository.findById(usuario.get().getIdUsuario());

		if (optRepresentante.isPresent())
			representanteRepository.delete(optRepresentante.get());

		Representante representante = new Representante(usuario.get(), solicitud.getIdOrganizacion(),
				solicitud.getNombreApellido(), solicitud.getDni(), solicitud.getCargo(), solicitud.getEmail());

		return representanteRepository.save(representante);
	}

}
