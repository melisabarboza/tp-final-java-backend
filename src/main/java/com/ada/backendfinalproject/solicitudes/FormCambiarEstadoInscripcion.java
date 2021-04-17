package com.ada.backendfinalproject.solicitudes;

import com.ada.backendfinalproject.entity.enums.EstadoInscripcion;

public class FormCambiarEstadoInscripcion {

	Integer idInscripcion;
	EstadoInscripcion estado;
	Integer porcentajeBeca;

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}

	public Integer getPorcentajeBeca() {
		return porcentajeBeca;
	}

	public void setPorcentajeBeca(Integer porcentajeBeca) {
		this.porcentajeBeca = porcentajeBeca;
	}

}
