package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.repository.ParticipanteRepository;
import com.ada.backendfinalproject.solicitudes.FormNewParticipante;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository participanteRepository;

	public Participante addNewParticipante(FormNewParticipante solicitud) {

		Participante participante = new Participante(0, solicitud.getNombreApellido(), solicitud.getFechaDeNacimiento(),
				solicitud.getGenero(), solicitud.getDomicilio(), solicitud.isEstaEstudiando(),
				solicitud.isEstaTrabajando(), solicitud.isTieneIngresos(), solicitud.getIngresoMensual(),
				solicitud.getFamiliaresACargo());
		participanteRepository.save(participante);

		return participante;
	}

	public Optional<Participante> getParticipanteById(Integer idParticipante) {

		Optional<Participante> participante = participanteRepository.findById(idParticipante);
		return participante;

	}
}
