package com.ada.backendfinalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.repository.CursoRepository;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;

	public Curso addNewCurso(FormNewCurso solicitud) throws Exception {

		// validaciones de negocio:
		// si el numero de participantes es menor o igual a 0, entonces ERROR
		// validar que las horas sean mayores a 0
		// validar que el costo no sea negativo
		if (solicitud.getNumeroParticipantes() <= 0) {
			throw new Exception("No se pueden crear un cusro sin cupos de participantes");
		}

		Curso curso = new Curso(0, solicitud.getNombre(), solicitud.getDescripcion(), solicitud.getModalidad(),
				solicitud.getCosto(), solicitud.getHoras(), solicitud.getCategoria(),
				solicitud.getNumeroParticipantes(), solicitud.getBecasDisponibles());

		Curso result = cursoRepository.save(curso);

		return result;
	}

	public List<Curso> getCursosDisponibles() {
		Iterable<Curso> itCursos = cursoRepository.findAll();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		itCursos.forEach(curso -> {
			cursos.add(curso);
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

	/*
	 * public List<Curso> getCursosPorParticipantes() { Iterable<Curso> itCursos =
	 * cursoRepository.findByParticipantes(); ArrayList<Curso> cursos = new
	 * ArrayList<Curso>(); itCursos.forEach(curso -> { cursos.add(curso); }); return
	 * cursos; }
	 * 
	 * public List<Curso> getCursosFinalizados() { Iterable<Curso> itCursos =
	 * cursoRepository.findByFinalizados(); ArrayList<Curso> cursos = new
	 * ArrayList<Curso>(); itCursos.forEach(curso -> { cursos.add(curso); }); return
	 * cursos; }
	 * 
	 * public List<Curso> getCursosPorCatOrg() { Iterable<Curso> itCursos =
	 * cursoRepository.findByCatOrg(); ArrayList<Curso> cursos = new
	 * ArrayList<Curso>(); itCursos.forEach(curso -> { cursos.add(curso); }); return
	 * cursos; }
	 */
}
