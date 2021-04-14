package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Organizacion;
import com.ada.backendfinalproject.repository.OrganizacionRepository;
import com.ada.backendfinalproject.solicitudes.FormNewOrganizacion;

@Service
public class OrganizacionService {

	@Autowired
	OrganizacionRepository organizacionRepository;

	public Organizacion addNewOrganizacion(FormNewOrganizacion solicitud) throws Exception {
		// validaciones de negocio:

		if (solicitud.getNombreOrg() == null || solicitud.getCuilOrg() == null) {
			throw new Exception("No se pueden registrar organizacion sin nombre/cuil");
		}

		Organizacion organizacion = new Organizacion(0, solicitud.getNombreOrg(), solicitud.getCuilOrg(),
				solicitud.getTipoOrg(), solicitud.getDireccionOrg(), solicitud.getCategoriaOrg(),
				solicitud.getAñoDeFundacionOrg(), solicitud.getNumeroDeContacto(), solicitud.getEstadoOrganizacion());

		Organizacion result = organizacionRepository.save(organizacion);

		return result;
	}

	public Optional<Organizacion> findById(Integer idOrganizacion) {
		return organizacionRepository.findById(idOrganizacion);
	}

}
