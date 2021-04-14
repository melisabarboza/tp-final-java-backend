package com.ada.backendfinalproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.repository.CursoRepository;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@SpringBootTest
public class CursoServiceTest {

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	CursoService service;

	@BeforeEach
	public void before() {
		cursoRepository.deleteAll();
	}

	/*
	 * public Curso addNewCurso(FormNewCurso solicitud) throws Exception {
	 * 
	 * // validaciones de negocio: // si el numero de participantes es menor o igual
	 * a 0, entonces ERROR // validar que las horas sean mayores a 0 // validar que
	 * el costo no sea negativo if (solicitud.getNumeroParticipantes() <= 0) { throw
	 * new Exception("No se pueden crear un curso sin cupos de participantes"); }
	 * 
	 * Curso curso = new Curso(0, solicitud.getNombre(), solicitud.getDescripcion(),
	 * solicitud.getModalidad(), solicitud.getCosto(), solicitud.getHoras(),
	 * solicitud.getCategoria(), solicitud.getNumeroParticipantes(),
	 * solicitud.getBecasDisponibles(), solicitud.getIdOrganizacion());
	 * 
	 * Curso result = cursoRepository.save(curso);
	 * 
	 * return result; }
	 */

	@Test
	public void testAddNewCurso() throws Exception {
		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setIdOrganizacion(20);
		form.setModalidad("distancia");
		form.setNombre("java");
		form.setNumeroParticipantes(80);

		Curso result = service.addNewCurso(form);

		assertTrue(result.getId() != 0);
		assertEquals(50, result.getBecasDisponibles());
		assertEquals("programación", result.getCategoría());
		assertEquals(500, result.getCosto());
		assertEquals("descripcion", result.getDescripcion());
		assertEquals(3, result.getHoras());
		assertEquals(20, result.getIdOrganizacion());
		assertEquals("distancia", result.getModalidad());
		assertEquals("java", result.getNombre());
		assertEquals(80, result.getNumeroParticipantes());

	}

	@Test
	public void testAddNewCursoException() throws Exception {
		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setIdOrganizacion(20);
		form.setModalidad("distancia");
		form.setNombre("java");
		form.setNumeroParticipantes(0);

		try {
			Curso result = service.addNewCurso(form);
			assertTrue(false);
		} catch (Exception e) {
			assertEquals("No se pueden crear un curso sin cupos de participantes", e.getMessage());
			assertTrue(true);
		}

	}

	@Test
	public void testGetCursosDisponibles() throws Exception {
		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setIdOrganizacion(20);
		form.setModalidad("distancia");

		form.setNombre("java");
		form.setNumeroParticipantes(80);
		Curso result = service.addNewCurso(form);

		form.setNombre("C#");
		form.setNumeroParticipantes(1);
		result = service.addNewCurso(form);
		service.restarVacante(result.getId());

		form.setNombre("javascript");
		form.setNumeroParticipantes(900);
		result = service.addNewCurso(form);

		List<Curso> cursos = service.getCursosDisponibles();

		assertEquals(2, cursos.size());
		assertTrue(cursos.get(0).getNombre().equals("java") || cursos.get(0).getNombre().equals("javascript"));
		assertTrue(cursos.get(1).getNombre().equals("java") || cursos.get(1).getNombre().equals("javascript"));

	}

}
