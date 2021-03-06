package com.ada.backendfinalproject.solicitudes;

import java.util.Date;

public class FormParticipante {

	String nombreApellido;
	Date fechaDeNacimiento;
	String genero;
	String domicilio;
	Boolean estaEstudiando;
	Boolean estaTrabajando;
	Boolean tieneIngresos;
	Integer ingresoMensual;
	Integer familiaresACargo;

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Boolean isEstaEstudiando() {
		return estaEstudiando;
	}

	public void setEstaEstudiando(Boolean estaEstudiando) {
		this.estaEstudiando = estaEstudiando;
	}

	public Boolean isEstaTrabajando() {
		return estaTrabajando;
	}

	public void setEstaTrabajando(Boolean estaTrabajando) {
		this.estaTrabajando = estaTrabajando;
	}

	public Boolean isTieneIngresos() {
		return tieneIngresos;
	}

	public void setTieneIngresos(Boolean tieneIngresos) {
		this.tieneIngresos = tieneIngresos;
	}

	public Integer getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(Integer ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public Integer getFamiliaresACargo() {
		return familiaresACargo;
	}

	public void setFamiliaresACargo(Integer familiaresACargo) {
		this.familiaresACargo = familiaresACargo;
	}

}
