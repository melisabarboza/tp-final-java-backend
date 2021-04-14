package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.repository.ParticipanteRepository;
import com.ada.backendfinalproject.solicitudes.FormParticipante;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository participanteRepository;

	@Autowired
	UsuarioService usuarioService;

	public Optional<Participante> getParticipanteById(Integer idUsuario) {
		Optional<Participante> participante = participanteRepository.findById(idUsuario);
		return participante;
	}

	public Participante reemplazarInformacion(FormParticipante solicitud) {
		Optional<Usuario> usuario = usuarioService.getUsuarioByUsuario(solicitud.getUsuario());

		Optional<Participante> optParticipante = participanteRepository.findById(usuario.get().getIdUsuario());
		if (optParticipante.isPresent())
			participanteRepository.delete(optParticipante.get());

		Participante participante = new Participante(usuario.get(), solicitud.getNombreApellido(),
				solicitud.getFechaDeNacimiento(), solicitud.getGenero(), solicitud.getDomicilio(),
				solicitud.isEstaEstudiando(), solicitud.isEstaTrabajando(), solicitud.isTieneIngresos(),
				solicitud.getIngresoMensual(), solicitud.getFamiliaresACargo());

		return participanteRepository.save(participante);
	}
}
