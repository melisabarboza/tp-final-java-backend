package com.ada.backendfinalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private CursoService cursoService;

	@PostMapping(path = "/add")
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
	public @ResponseBody List<Curso> getCursosDisponibles() {
		List<Curso> cursosDisponibles = cursoService.getCursosDisponibles();
		return cursosDisponibles;
	}

	@GetMapping(path = "/categorias") // Todos los cursos por categoría public
	public @ResponseBody List<Curso> getCursosPorCategorias(@RequestParam String categoria) {
		List<Curso> cursosPorCategoria = cursoService.getCursosPorCategoria(categoria);

		return cursosPorCategoria;
	}

	@GetMapping(path = "/organizaciones") // Todos los cursos por organización
	public @ResponseBody List<Curso> getCursosPorOrganizacion(@RequestParam Integer idOrganizacion) {
		List<Curso> cursosPorOrganizacion = cursoService.getCursosPorOrganizacion(idOrganizacion);
		return cursosPorOrganizacion;
	}

	/*
	 * @GetMapping(path = "/participantes") // Todos los cursos por participante (en
	 * progreso) public List<Curso> getCursosPorParticipantes() { List<Curso>
	 * cursosPorParticipantes = cursoService.getCursosPorParticipantes(); return
	 * cursosPorParticipantes; }
	 * 
	 * @GetMapping(path = "/finalizados") // Todos los cursos por participante
	 * (finalizados) public List<Curso> getCursosFinalizados() { List<Curso>
	 * cursosFinalizados = cursoService.getCursosFinalizados(); return
	 * cursosFinalizados; }
	 * 
	 * @GetMapping(path = "/org/cat") // Todos los cursos por organización y
	 * categoría public List<Curso> getCursosPorCatOrg() { List<Curso>
	 * cursosPorCatOrg = cursoService.getCursosPorCatOrg(); return cursosPorCatOrg;
	 * }
	 */
}