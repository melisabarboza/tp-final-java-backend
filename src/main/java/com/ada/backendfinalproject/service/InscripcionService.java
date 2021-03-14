package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Inscripcion;
import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.entity.enums.EstadoInscripcion;
import com.ada.backendfinalproject.repository.InscripcionRepository;
import com.ada.backendfinalproject.solicitudes.FormNewInscripcion;

@Service
public class InscripcionService {

	@Autowired
	InscripcionRepository inscripcionRepository;

	@Autowired
	ParticipanteService participanteService;

	public Inscripcion addNewInscripcion(FormNewInscripcion solicitud) throws Exception {

		Inscripcion inscripcion = new Inscripcion(0, solicitud.getIdCurso(), solicitud.getIdParticipante(),
				solicitud.getSolicitaBeca(), null, EstadoInscripcion.PENDIENTE.name());

		if (solicitud.getSolicitaBeca()) {
			Optional<Participante> optParticipante = participanteService
					.getParticipanteById(solicitud.getIdParticipante());

			if (optParticipante.isPresent()) {
				Participante participante = optParticipante.get();

				if (participante.DatosSocioEconomicosCargados()) {
					return inscripcionRepository.save(inscripcion);
				} else
					throw new Exception("Datos socioeconomicos no cargados");
			} else
				throw new Exception("Participante inexistente");
		} else
			return inscripcionRepository.save(inscripcion);

	}

	public Iterable<Inscripcion> getInscripcionPorIdParticipante(Integer idParticipante) {

		Iterable<Inscripcion> itInscripciones = inscripcionRepository.findByIdParticipante(idParticipante);

		return itInscripciones;

	}
}