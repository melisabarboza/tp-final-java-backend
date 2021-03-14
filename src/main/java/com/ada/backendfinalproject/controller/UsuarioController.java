package com.ada.backendfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Participante;
import com.ada.backendfinalproject.service.ParticipanteService;
import com.ada.backendfinalproject.service.UsuarioService;
import com.ada.backendfinalproject.solicitudes.FormNewParticipante;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	ParticipanteService participanteService;

	@PostMapping(path = "paticipantes/add")
	public @ResponseBody Participante add(@RequestBody FormNewParticipante solicitud) throws Exception {

		Participante newPaticipate = participanteService.addNewParticipante(solicitud);

		return newPaticipate;
	}

}
