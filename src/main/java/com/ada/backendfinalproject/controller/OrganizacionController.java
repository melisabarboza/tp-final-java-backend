package com.ada.backendfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Organizacion;
import com.ada.backendfinalproject.service.OrganizacionService;
import com.ada.backendfinalproject.solicitudes.FormCambiarEstadoOrganizacion;
import com.ada.backendfinalproject.solicitudes.FormNewOrganizacion;

@RestController

@RequestMapping(path = "/organizaciones")
public class OrganizacionController {

	@Autowired
	private OrganizacionService organizacionService;

	@PostMapping(path = "/registro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody Organizacion addNewOrganizacion(@RequestBody FormNewOrganizacion solicitud) throws Exception {

		// TODO: agregar otras validaciones

		Organizacion organizacionRegistrada = organizacionService.addNewOrganizacion(solicitud);

		return organizacionRegistrada;
	}

	@PostMapping(path = "/estado")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public @ResponseBody Organizacion cambiarEstado(@RequestBody FormCambiarEstadoOrganizacion solicitud)
			throws Exception {

		return organizacionService.cambiarEstado(solicitud);

	}
}
