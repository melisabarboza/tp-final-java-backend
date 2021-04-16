package com.ada.backendfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Inscripcion;
import com.ada.backendfinalproject.service.InscripcionService;
import com.ada.backendfinalproject.solicitudes.FormCambiarEstadoInscripcion;
import com.ada.backendfinalproject.solicitudes.FormFinalizarInscripcion;
import com.ada.backendfinalproject.solicitudes.FormNewInscripcion;

@RestController
@RequestMapping(path = "/inscripcion")
public class InscripcionController {

	@Autowired
	private InscripcionService inscripcionService;

	@PostMapping(path = "/add")
	@PreAuthorize("hasRole('ROLE_PARTICIPANTE')")
	public @ResponseBody Inscripcion add(@RequestBody FormNewInscripcion solicitud) throws Exception {

		// TODO: agregar otras validaciones

		Inscripcion newInscripcion = inscripcionService.addNewInscripcion(solicitud);

		return newInscripcion;
	}

	@PostMapping(path = "/estado")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody Inscripcion cambiarEstado(@RequestBody FormCambiarEstadoInscripcion solicitud)
			throws Exception {

		return inscripcionService.cambiarEstado(solicitud);

	}

	@PostMapping(path = "/finalizar")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody Inscripcion cambiarEstado(@RequestBody FormFinalizarInscripcion solicitud) throws Exception {

		return inscripcionService.finalizar(solicitud);

	}
}
