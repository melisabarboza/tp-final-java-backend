package com.ada.backendfinalproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ada.backendfinalproject.entity.Curso;
import com.ada.backendfinalproject.entity.Organizacion;
import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.entity.enums.EstadoOrganizacion;
import com.ada.backendfinalproject.entity.enums.RolUsuario;
import com.ada.backendfinalproject.repository.CursoRepository;
import com.ada.backendfinalproject.repository.OrganizacionRepository;
import com.ada.backendfinalproject.repository.RepresentanteRepository;
import com.ada.backendfinalproject.repository.UsuarioRepository;
import com.ada.backendfinalproject.solicitudes.FormNewCurso;

@SpringBootTest
public class CursoServiceTest {

	@Autowired
	CursoService service;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RepresentanteService representanteService;

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	OrganizacionRepository organizacionRepository;

	@Autowired
	RepresentanteRepository representanteRepository;

	@BeforeEach
	public void before() {
		cursoRepository.deleteAll();
		representanteRepository.deleteAll();
		organizacionRepository.deleteAll();
		usuarioRepository.deleteAll();
		Usuario usuario = new Usuario(1, "test", "cont", RolUsuario.REPRESENTANTE);
		usuario = usuarioRepository.save(usuario);
		Organizacion organizacion = new Organizacion(1, "nombre", 1l, 1, "dir", "cat", 2, 3,
				EstadoOrganizacion.APROBADO.name());
		organizacion = organizacionRepository.save(organizacion);

		Representante rep = new Representante(usuario, organizacion, "nombre", 1l, "cargo", "email");
		rep.setUsuarioId(usuario.getIdUsuario());
		rep = representanteRepository.save(rep);
	}

	@Test
	public void testAddNewCurso() throws Exception {

		FormNewCurso form = new FormNewCurso();
		form.setBecasDisponibles(50);
		form.setCategoria("programación");
		form.setCosto(500);
		form.setDescripcion("descripcion");
		form.setHoras(3);
		form.setModalidad("distancia");
		form.setNombre("java");
		form.setNumeroParticipantes(80);

		Curso result = service.addNewCurso(form, "test");

		assertTrue(result.getId() != 0);
		assertEquals(50, result.getBecasDisponibles());
		assertEquals("programación", result.getCategoría());
		assertEquals(500, result.getCosto());
		assertEquals("descripcion", result.getDescripcion());
		assertEquals(3, result.getHoras());
		assertEquals(representanteRepository.findAll().iterator().next().getOrganizacion().getIdOrganizacion(),
				result.getIdOrganizacion());
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
		form.setModalidad("distancia");
		form.setNombre("java");
		form.setNumeroParticipantes(0);

		try {
			Curso result = service.addNewCurso(form, "test");
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
		form.setModalidad("distancia");

		form.setNombre("java");
		form.setNumeroParticipantes(80);
		Curso result = service.addNewCurso(form, "test");

		form.setNombre("C#");
		form.setNumeroParticipantes(1);
		result = service.addNewCurso(form, "test");
		service.restarVacante(result.getId());

		form.setNombre("javascript");
		form.setNumeroParticipantes(900);
		result = service.addNewCurso(form, "test");

		List<Curso> cursos = service.getCursosDisponibles();

		assertEquals(2, cursos.size());
		assertTrue(cursos.get(0).getNombre().equals("java") || cursos.get(0).getNombre().equals("javascript"));
		assertTrue(cursos.get(1).getNombre().equals("java") || cursos.get(1).getNombre().equals("javascript"));

	}

}
