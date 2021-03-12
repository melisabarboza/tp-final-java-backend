package com.ada.backendfinalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.backendfinalproject.entity.Inscripcion;
import com.ada.backendfinalproject.service.InscripcionService;
import com.ada.backendfinalproject.solicitudes.FormNewParticipante;

@RestController
@RequestMapping(path = "/inscripciones")
public class InscripcionController {

	@Autowired
	private InscripcionService inscripcionService;

	@PostMapping(path = "/add")
	public @ResponseBody Inscripcion add(@RequestBody FormNewParticipante solicitud) throws Exception {

		// valido que lleguen los parametros necesarios para guardar un curso

		// if (solicitud.getNombre() == null || solicitud.getNombre() == "") {
		// throw new Exception("la solicitud debe contener un nombre valido");
		// }
		// TODO: agregar otras validaciones

		Inscripcion newInscripcion = InscripcionService.addNewInscripcion(solicitud);

		return newInscripcion;
	}
}
