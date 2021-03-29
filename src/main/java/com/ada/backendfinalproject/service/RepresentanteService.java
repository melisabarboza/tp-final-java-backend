package com.ada.backendfinalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Representante;
import com.ada.backendfinalproject.repository.RepresentanteRepository;
import com.ada.backendfinalproject.solicitudes.FormRepresentante;

@Service
public class RepresentanteService {

	@Autowired
	RepresentanteRepository representanteRepository;

	public Representante addNew(FormRepresentante solicitud) {
		// Validar que la organizacion este aprobada

		Representante representante = new Representante(0, solicitud.getIdOrganizacion(), solicitud.getNombreApellido(),
				solicitud.getDni(), solicitud.getCargo(), solicitud.getEmail());

		representanteRepository.save(representante);
		return representante;

	}

}
