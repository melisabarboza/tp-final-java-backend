package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Curso;
import io.swagger.v3.oas.annotations.Operation;
import repository.CursoRepository;

@Controller
@RequestMapping(path = "/app")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping(path = "/add")
	@Operation(summary = "Register a new infected", description = "Saves a new infected in the data base")

	public @ResponseBody Curso addNewCurso(@RequestParam String nombre, @RequestParam String descripcion,
			@RequestParam String modalidad, @RequestParam Integer costoCurso, @RequestParam Integer horas,
			@RequestParam String categoria, @RequestParam Integer numeroParticipantes,
			@RequestParam Integer cuposConBecas) {

		Curso curso = new Curso(nombre, descripcion, modalidad, costoCurso, horas, categoria, numeroParticipantes,
				cuposConBecas);
		Curso result = cursoRepository.save(curso);
		return curso;
	}
}
