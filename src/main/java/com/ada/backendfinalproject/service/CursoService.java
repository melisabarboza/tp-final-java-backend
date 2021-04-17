package com.ada.backendfinalproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.entity.Inscripcion;
import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.repository.CursoRepository;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@Service
public class CursoService {

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	InscripcionService inscripcionService;

	@Autowired
	RepresentanteService representanteService;

	public CursoService() {

	}

	public CursoService(CursoRepository cursoRepository, InscripcionService inscripcionService) {
		this.cursoRepository = cursoRepository;
		this.inscripcionService = inscripcionService;
	}

	public Curso addNewCurso(FormNewCurso solicitud, String usuario) throws Exception {

		Optional<Representante> optRepresentante = representanteService.findByUsuario(usuario);
		if (!optRepresentante.isPresent())
			throw new Exception("representante no encontrado");

		if (solicitud.getNumeroParticipantes() <= 0) {
			throw new Exception("No se pueden crear un curso sin cupos de participantes");
		}

		Curso curso = new Curso(0, solicitud.getNombre(), solicitud.getDescripcion(), solicitud.getModalidad(),
				solicitud.getCosto(), solicitud.getHoras(), solicitud.getCategoria(),
				solicitud.getNumeroParticipantes(), solicitud.getBecasDisponibles(),
				optRepresentante.get().getOrganizacion().getIdOrganizacion());

		Curso result = cursoRepository.save(curso);

		return result;
	}

	public List<Curso> getCursosDisponibles() {
		Iterable<Curso> itCursos = cursoRepository.findAll();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		itCursos.forEach(curso -> {
			if (curso.getNumeroParticipantes() > 0) {
				cursos.add(curso);
			}
		});
		return cursos;
	}

	public List<Curso> getCursosPorCategoria(String categoria) {
		Iterable<Curso> itCursos = cursoRepository.findByCategoria(categoria);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		itCursos.forEach(curso -> {
			cursos.add(curso);
		});
		return cursos;
	}

	public List<Curso> getCursosPorOrganizacion(Integer idOrganizacion) {
		Iterable<Curso> itCursos = cursoRepository.findByIdOrganizacion(idOrganizacion);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		itCursos.forEach(curso -> {
			cursos.add(curso);
		});
		return cursos;
	}

	public Iterable<Curso> getCursosEnProgresoPorParticipante(Integer idParticipante) {

		Iterable<Inscripcion> inscripcionesDelParticipante = inscripcionService
				.getInscripcionAprobadasPorIdParticipante(idParticipante);

		List<Integer> listaIdCursoParticipante = new ArrayList<Integer>();
		inscripcionesDelParticipante.forEach(inscripcion -> {
			listaIdCursoParticipante.add(inscripcion.getCurso().getId());
		});

		Iterable<Curso> cursosDelParticipante = cursoRepository.findAllById(listaIdCursoParticipante);

		return cursosDelParticipante;
	}

	public Optional<Curso> getCursoById(Integer idCurso) {

		Optional<Curso> curso = cursoRepository.findById(idCurso);
		return curso;
	}

	public void restarVacante(Integer idCurso) {

		Optional<Curso> curso = cursoRepository.findById(idCurso);
		curso.get().restarVacante();
		cursoRepository.save(curso.get());
	}

	public void restarVacanteYBeca(Integer idCurso) {

		Optional<Curso> curso = cursoRepository.findById(idCurso);
		curso.get().restarBeca();
		curso.get().restarVacante();
		cursoRepository.save(curso.get());
	}

	public Iterable<Curso> getCursosFinalizadosPorParticipante(Integer idParticipante) {

		Iterable<Inscripcion> inscripcionesDelParticipante = inscripcionService
				.getInscripcionFinalizadaPorIdParticipante(idParticipante);

		List<Integer> listaIdCursoParticipante = new ArrayList<Integer>();
		inscripcionesDelParticipante.forEach(inscripcion -> {
			listaIdCursoParticipante.add(inscripcion.getCurso().getId());
		});

		Iterable<Curso> cursosDelParticipante = cursoRepository.findAllById(listaIdCursoParticipante);

		return cursosDelParticipante;
	}

	public Iterable<Curso> getCursosPorCatOrg(Integer idOrganizacion, String categoria) {
		return cursoRepository.findByIdOrganizacionAndCategoria(idOrganizacion, categoria);
	}

}
