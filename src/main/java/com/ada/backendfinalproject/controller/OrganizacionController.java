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
import com.ada.backendfinalproject.solicitudes.FormNewOrganizacion;

@RestController

@RequestMapping(path = "/organizaciones")
public class OrganizacionController {

	@Autowired
	private OrganizacionService organizacionService;

	@PostMapping(path = "/registro")
	@PreAuthorize("hasRole('ROLE_REPRESENTANTE')")
	public @ResponseBody Organizacion addNewOrganizacion(@RequestBody FormNewOrganizacion solicitud) throws Exception {

		// valido que lleguen los parametros necesarios para guardar una organizacion
		// if (solicitud.getNombreOrg() == null || solicitud.getCuilOrg() == 0) {
		// throw new Exception("la solicitud debe contener un nombre valido");
		// }
		// TODO: agregar otras validaciones

		Organizacion organizacionRegistrada = organizacionService.addNewOrganizacion(solicitud);

		return organizacionRegistrada;
	}

	// CAMBIAR ESTADO ORG
}
