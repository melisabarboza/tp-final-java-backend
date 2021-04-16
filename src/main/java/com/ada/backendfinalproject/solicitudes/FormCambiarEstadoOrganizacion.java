package com.ada.backendfinalproject.solicitudes;

import com.ada.backendfinalproject.entity.enums.EstadoOrganizacion;

public class FormCambiarEstadoOrganizacion {

	Integer idOrganizacion;
	EstadoOrganizacion estado;

	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public EstadoOrganizacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrganizacion estado) {
		this.estado = estado;
	}

}
