package com.ada.backendfinalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.service.CursoService;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {

	public CursoController() {

	}

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@Autowired
	private CursoService cursoService;

	@PostMapping(path = "/add")
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE')")
	public @ResponseBody Curso addNewCurso(@RequestBody FormNewCurso solicitud) throws Exception {

		// valido que lleguen los parametros necesarios para guardar un curso
		if (solicitud.getNombre() == null || solicitud.getNombre() == "") {
			throw new Exception("la solicitud debe contener un nombre valido");
		}
		// TODO: agregar otras validaciones

		Curso cursoCreado = cursoService.addNewCurso(solicitud);
		return cursoCreado;
	}

	@GetMapping(path = "/disponibles") // cursos disponibles (con cupos abiertos)
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public @ResponseBody List<Curso> getCursosDisponibles() {

		List<Curso> cursosDisponibles = cursoService.getCursosDisponibles();
		return cursosDisponibles;
	}

	@GetMapping(path = "/categorias") // Todos los cursos por categoría public
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public @ResponseBody List<Curso> getCursosPorCategorias(@RequestParam String categoria) {

		List<Curso> cursosPorCategoria = cursoService.getCursosPorCategoria(categoria);
		return cursosPorCategoria;
	}

	@GetMapping(path = "/organizaciones") // Todos los cursos por organización
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public @ResponseBody List<Curso> getCursosPorOrganizacion(@RequestParam Integer idOrganizacion) {

		List<Curso> cursosPorOrganizacion = cursoService.getCursosPorOrganizacion(idOrganizacion);
		return cursosPorOrganizacion;
	}

	@GetMapping(path = "/participantes/progreso") // Todos los cursos por participante (en progreso)
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public @ResponseBody Iterable<Curso> getCursosEnProgresoPorParticipante(@RequestParam Integer idParticipante) {

		Iterable<Curso> cursosEnProgreso = cursoService.getCursosEnProgresoPorParticipante(idParticipante);
		return cursosEnProgreso;
	}

	@GetMapping(path = "/participantes/finalizados")
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public Iterable<Curso> getCursosFinalizados(@RequestParam Integer idParticipante) {
		Iterable<Curso> cursosFinalizados = cursoService.getCursosFinalizadosPorParticipante(idParticipante);
		return cursosFinalizados;
	}

	@GetMapping(path = "/orgaycateg")
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE') OR hasRole('ROLE_ADMIN') OR hasRole('ROLE_PARTICIPANTE')  ")
	public Iterable<Curso> getCursosPorCatOrg(@RequestParam Integer idOrganizacion, @RequestParam String categoria) {
		Iterable<Curso> cursosPorCatOrg = cursoService.getCursosPorCatOrg(idOrganizacion, categoria);
		return cursosPorCatOrg;
	}

}
