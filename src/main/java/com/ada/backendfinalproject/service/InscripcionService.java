package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.entity.Inscripcion;
import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.entity.enums.EstadoInscripcion;
import com.ada.backendfinalproject.repository.InscripcionRepository;
import com.ada.backendfinalproject.solicitudes.FormCambiarEstadoInscripcion;
import com.ada.backendfinalproject.solicitudes.FormFinalizarInscripcion;
import com.ada.backendfinalproject.solicitudes.FormNewInscripcion;

@Service
public class InscripcionService {

	@Autowired
	InscripcionRepository inscripcionRepository;

	@Autowired
	ParticipanteService participanteService;

	@Autowired
	CursoService cursoService;

	public Inscripcion addNewInscripcion(FormNewInscripcion solicitud) throws Exception {

		// TODO: Validar que el curso tenga cupos disponibles
		Optional<Curso> cursoOpt = cursoService.getCursoById(solicitud.getIdCurso());

		if (cursoOpt.isPresent()) {
			Integer cantidadParticipantes = cursoOpt.get().getNumeroParticipantes();
			if (cantidadParticipantes <= 0) {
				throw new Exception("El curso solicitado ya no posee vacantes disponibles");
			}

		} else {
			throw new Exception("IdCurso invalido");
		}

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
		} else {
			inscripcion.setEstadoInscripcion(EstadoInscripcion.APROBADO.name());
			cursoService.restarVacante(solicitud.getIdCurso());
			return inscripcionRepository.save(inscripcion);
		}
	}

	public Iterable<Inscripcion> getInscripcionPorIdParticipante(Integer idParticipante) {
		Iterable<Inscripcion> itInscripciones = inscripcionRepository.findByIdParticipante(idParticipante);
		return itInscripciones;
	}

	public Iterable<Inscripcion> getInscripcionAprobadasPorIdParticipante(Integer idParticipante) {
		Iterable<Inscripcion> itInscripciones = inscripcionRepository
				.findByIdParticipanteAndEstadoInscripcion(idParticipante, EstadoInscripcion.APROBADO.name());
		return itInscripciones;
	}

	public Iterable<Inscripcion> getInscripcionFinalizadaPorIdParticipante(Integer idParticipante) {
		Iterable<Inscripcion> itInscripciones = inscripcionRepository
				.findByIdParticipanteAndEstadoInscripcion(idParticipante, EstadoInscripcion.FINALIZADO.name());
		return itInscripciones;
	}

	public Inscripcion cambiarEstado(FormCambiarEstadoInscripcion solicitud) throws Exception {

		Optional<Inscripcion> inscripcion = inscripcionRepository.findById(solicitud.getIdInscripcion());

		if (!inscripcion.isPresent()) {
			throw new Exception("Inscripcion no encontrada");
		}

		if (!inscripcion.get().getEstadoInscripcion().equals(EstadoInscripcion.PENDIENTE.name())) {
			throw new Exception("El estado de la inscripción ya fue modificado anteriormente");
		}

		if (solicitud.getPorcentajeBeca() != 50 && solicitud.getPorcentajeBeca() != 75
				&& solicitud.getPorcentajeBeca() != 100) {
			throw new Exception("Porcentaje beca incorrecto");
		}
		if (solicitud.getEstado() == EstadoInscripcion.PENDIENTE) {
			throw new Exception("El estado de inscripcion es invalido");
		}

		inscripcion.get().setEstadoInscripcion(solicitud.getEstado().name());

		if (solicitud.getEstado() == EstadoInscripcion.APROBADO) {
			inscripcion.get().setPorcentajeBeca(solicitud.getPorcentajeBeca());
			cursoService.restarVacanteYBeca(inscripcion.get().getIdCurso());
		}

		return inscripcionRepository.save(inscripcion.get());
	}

	public Inscripcion finalizar(FormFinalizarInscripcion solicitud) throws Exception {
		Optional<Inscripcion> inscripcion = inscripcionRepository.findById(solicitud.getIdInscripcion());
		if (!inscripcion.isPresent()) {
			throw new Exception("Inscripcion no encontrada");
		}
		if (inscripcion.get().getEstadoInscripcion() != EstadoInscripcion.APROBADO.name()) {
			throw new Exception("El estado actual de la inscripcion no es APROBADO");
		}
		inscripcion.get().setEstadoInscripcion(EstadoInscripcion.FINALIZADO.name());
		return inscripcionRepository.save(inscripcion.get());

	}
}