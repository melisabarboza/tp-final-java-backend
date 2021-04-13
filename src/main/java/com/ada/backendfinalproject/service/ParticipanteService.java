package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.repository.ParticipanteRepository;
import com.ada.backendfinalproject.solicitudes.FormParticipante;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository participanteRepository;

	public Participante addNewParticipante(FormParticipante solicitud) {

		Participante participante = new Participante(0, solicitud.getUsuario(), solicitud.getNombreApellido(),
				solicitud.getFechaDeNacimiento(), solicitud.getGenero(), solicitud.getDomicilio(),
				solicitud.isEstaEstudiando(), solicitud.isEstaTrabajando(), solicitud.isTieneIngresos(),
				solicitud.getIngresoMensual(), solicitud.getFamiliaresACargo());
		participanteRepository.save(participante);

		return participante;
	}

	public Optional<Participante> getParticipanteById(Integer idParticipante) {

		Optional<Participante> participante = participanteRepository.findById(idParticipante);
		return participante;

	}

	public Participante reemplazarInformacion(FormParticipante solicitud) {
		Optional<Participante> optParticipante = participanteRepository.findByUsuario(solicitud.getUsuario());
		if (optParticipante.isPresent())
			participanteRepository.delete(optParticipante.get());

		Participante participante = new Participante(0, solicitud.getUsuario(), solicitud.getNombreApellido(),
				solicitud.getFechaDeNacimiento(), solicitud.getGenero(), solicitud.getDomicilio(),
				solicitud.isEstaEstudiando(), solicitud.isEstaTrabajando(), solicitud.isTieneIngresos(),
				solicitud.getIngresoMensual(), solicitud.getFamiliaresACargo());

		return participanteRepository.save(participante);
	}
}
