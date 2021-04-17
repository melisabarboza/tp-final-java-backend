package com.ada.backendfinalproject.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.security.Constants;
import com.ada.backendfinalproject.security.TokenProvider;
import com.ada.backendfinalproject.service.ParticipanteService;
import com.ada.backendfinalproject.service.RepresentanteService;
import com.ada.backendfinalproject.service.UsuarioService;
import com.ada.backendfinalproject.solicitudes.FormLogIn;
import com.ada.backendfinalproject.solicitudes.FormParticipante;
import com.ada.backendfinalproject.solicitudes.FormRepresentante;
import com.ada.backendfinalproject.solicitudes.FormUsuario;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	ParticipanteService participanteService;

	@Autowired
	RepresentanteService representanteService;

	@Autowired
	UsuarioService usuarioService;

	@PutMapping(path = "/participante")
	@PreAuthorize("hasRole('ROLE_PARTICIPANTE')")
	public ResponseEntity putParticipante(@RequestBody FormParticipante solicitud) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Participante newPaticipate = participanteService.reemplazarInformacion(solicitud, currentPrincipalName);

		return ResponseEntity.status(HttpStatus.OK).body(newPaticipate);

	}

	@PutMapping(path = "/representante")
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE')")
	public ResponseEntity putRepresentante(@RequestBody FormRepresentante solicitud) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Representante newRepresentante = representanteService.reemplazarInformacion(solicitud, currentPrincipalName);

		return ResponseEntity.status(HttpStatus.OK).body(newRepresentante);

	}

	@PostMapping(path = "/add")
	public @ResponseBody Usuario addUsuario(@RequestBody FormUsuario solicitud) throws Exception {
		Usuario newUsuario = usuarioService.addNew(solicitud);
		return newUsuario;
	}

	@PostMapping(path = "/login")
	public ResponseEntity login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody FormLogIn solicitud) throws Exception {

		Optional<Usuario> newUsuario = usuarioService.getUsuarioBy(solicitud.getUsuario(), solicitud.getContraseña());
		if (newUsuario.isPresent()) {
			UserDetails ud = usuarioService.getUserDetailsByUser(newUsuario.get());

			String token = TokenProvider.generateToken(ud);
			response.addHeader(Constants.HEADER_AUTHORIZATION_KEY, Constants.TOKEN_BEARER_PREFIX + " " + token);

			return ResponseEntity.status(HttpStatus.OK).body(newUsuario.get());
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("usuario o contraseña invalidas");
	}

	public UsuarioController() {

	}

	public UsuarioController(ParticipanteService participanteService, RepresentanteService representanteService,
			UsuarioService usuarioService) {
		this.participanteService = participanteService;
		this.representanteService = representanteService;
		this.usuarioService = usuarioService;
	}
}
