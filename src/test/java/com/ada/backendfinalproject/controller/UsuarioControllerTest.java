package com.ada.backendfinalproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.entity.enums.RolUsuario;
import com.ada.backendfinalproject.service.ParticipanteService;
import com.ada.backendfinalproject.service.RepresentanteService;
import com.ada.backendfinalproject.service.UsuarioService;
import com.ada.backendfinalproject.solicitudes.FormUsuario;

@SpringBootTest
public class UsuarioControllerTest {

	UsuarioService usuarioService;
	ParticipanteService partService;
	RepresentanteService repService;
	UsuarioController controller;

	@BeforeEach
	public void beforeTests() {
		// creo mocks
		usuarioService = Mockito.mock(UsuarioService.class);
		partService = Mockito.mock(ParticipanteService.class);
		repService = Mockito.mock(RepresentanteService.class);

		// creo el controller a testear
		controller = new UsuarioController(partService, repService, usuarioService);

	}

	@Test
	void testAltaNuevoUsuarioAdmin() throws Exception {

		// creo los datos de prueba
		Usuario usr = new Usuario(25, "abc", "123", RolUsuario.ADMIN);

		FormUsuario form = new FormUsuario();
		form.setContraseña("123");
		form.setUsuario("abc");
		form.setRol(RolUsuario.ADMIN);

		// mockeo los metodos externos al controller
		Mockito.doReturn(usr).when(usuarioService).addNew(form);

		// ejecuto metodo a testear
		Usuario result = controller.addUsuario(form);

		assertEquals("abc", result.getUsuario());
		assertEquals("123", result.getContraseña());
		assertEquals(RolUsuario.ADMIN, result.getRol());

	}

}
