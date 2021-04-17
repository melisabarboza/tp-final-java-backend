package com.ada.backendfinalproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.service.CursoService;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@SpringBootTest
public class CursoControllerTest {

	CursoService service;
	CursoController controller;

	@BeforeEach
	public void beforeTests() {
		// creo mocks
		service = Mockito.mock(CursoService.class);

		// creo el controller a testear
		controller = new CursoController(service);

		Authentication authentication = Mockito.mock(Authentication.class);
		Mockito.doReturn("nombreUsuarioTestAutenticado").when(authentication).getName();
		// Mockito.whens() for your authorization object
		SecurityContext securityContext = Mockito.mock(SecurityContext.class);
		Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);

	}

	@Test
	void testAddNewCursoConNombreStringVacio() {

		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setModalidad("distancia");
		form.setNombre("");
		form.setNumeroParticipantes(80);

		try {
			Curso result = controller.addNewCurso(form);
			assertTrue(false);
		} catch (Exception e) {
			assertEquals("la solicitud debe contener un nombre valido", e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	void testAddNewCursoConNombreNull() {

		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setModalidad("distancia");
		form.setNombre(null);
		form.setNumeroParticipantes(80);

		try {
			Curso result = controller.addNewCurso(form);
			assertTrue(false);
		} catch (Exception e) {
			assertEquals("la solicitud debe contener un nombre valido", e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	void testAddNewCurso() throws Exception {
		// creo los datos de prueba
		Curso curso = new Curso(33, "java", "descripcion", "distancia", 500, 3, "programación", 80, 50, 20);

		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setModalidad("distancia");
		form.setNombre("java");
		form.setNumeroParticipantes(80);

		// mockeo los metodos externos al controller

		Mockito.doReturn(curso).when(service).addNewCurso(form, "nombreUsuarioTestAutenticado");

		// ejecuto metodo a testear
		Curso result = controller.addNewCurso(form);

		assertEquals(form.getBecasDisponibles(), result.getBecasDisponibles());
		assertEquals(form.getCategoria(), result.getCategoría());
		assertEquals(form.getCosto(), result.getCosto());
		assertEquals(form.getDescripcion(), result.getDescripcion());
		assertEquals(form.getHoras(), result.getHoras());
		assertEquals(form.getModalidad(), result.getModalidad());
		assertEquals(form.getNombre(), result.getNombre());
		assertEquals(form.getNumeroParticipantes(), result.getNumeroParticipantes());

	}

}
