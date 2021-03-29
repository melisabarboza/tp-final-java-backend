package com.ada.backendfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.service.ParticipanteService;
import com.ada.backendfinalproject.service.RepresentanteService;
import com.ada.backendfinalproject.service.UsuarioService;
import com.ada.backendfinalproject.solicitudes.FormNewParticipante;
import com.ada.backendfinalproject.solicitudes.FormRepresentante;
import com.ada.backendfinalproject.solicitudes.FormUsuario;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	@Autowired
	ParticipanteService participanteService;

	@Autowired
	RepresentanteService representanteService;

	@Autowired
	UsuarioService usuarioService;

	@PostMapping(path = "paticipantes/add")
	public @ResponseBody Participante addParticipante(@RequestBody FormNewParticipante solicitud) throws Exception {

		Participante newPaticipate = participanteService.addNewParticipante(solicitud);

		return newPaticipate;
	}

	@PostMapping(path = "representante/add")
	public @ResponseBody Representante addRepresentante(@RequestBody FormRepresentante solicitud) throws Exception {

		Representante newRepresentante = representanteService.addNew(solicitud);

		return newRepresentante;
	}

	@PostMapping(path = "/add")
	public @ResponseBody Usuario addUsuario(@RequestBody FormUsuario solicitud) throws Exception {

		Usuario newUsuario = usuarioService.addNew(solicitud);

		return newUsuario;

	}
}
