package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Organizacion;
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

	@Autowired
	OrganizacionService organizacionService;

	public Representante reemplazarInformacion(FormRepresentante solicitud) {
		Optional<Usuario> usuario = usuarioService.getUsuarioByUsuario(solicitud.getUsuario());
		Optional<Organizacion> organizacion = organizacionService.findById(solicitud.getIdOrganizacion());

		Optional<Representante> optRepresentante = representanteRepository.findById(usuario.get().getIdUsuario());
		if (optRepresentante.isPresent())
			representanteRepository.delete(optRepresentante.get());

		Representante representante = new Representante(usuario.get(), organizacion.get(),
				solicitud.getNombreApellido(), solicitud.getDni(), solicitud.getCargo(), solicitud.getEmail());

		return representanteRepository.save(representante);
	}

}
