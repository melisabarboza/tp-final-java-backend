package com.ada.backendfinalproject.solicitudes;

import java.util.Date;

public class FormNewParticipante {

	private Integer id;
	String nombreApellido;
	Date fechaDeNacimiento;
	String genero;
	String domicilio;
	boolean estaEstudiando;
	boolean estaTrabajando;
	boolean tieneIngresos;
	Integer ingresoMensual;
	boolean tieneFamiliaACargo;
	Integer familiaresACargo;
	boolean abonaTotalCurso;
	boolean solicitaBeca;

	public String getNombreApellido() {
		return nombreApellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isEstaEstudiando() {
		return estaEstudiando;
	}

	public void setEstaEstudiando(boolean estaEstudiando) {
		this.estaEstudiando = estaEstudiando;
	}

	public boolean isEstaTrabajando() {
		return estaTrabajando;
	}

	public void setEstaTrabajando(boolean estaTrabajando) {
		this.estaTrabajando = estaTrabajando;
	}

	public boolean isTieneIngresos() {
		return tieneIngresos;
	}

	public void setTieneIngresos(boolean tieneIngresos) {
		this.tieneIngresos = tieneIngresos;
	}

	public Integer getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(Integer ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public boolean isTieneFamiliaACargo() {
		return tieneFamiliaACargo;
	}

	public void setTieneFamiliaACargo(boolean tieneFamiliaACargo) {
		this.tieneFamiliaACargo = tieneFamiliaACargo;
	}

	public Integer getFamiliaresACargo() {
		return familiaresACargo;
	}

	public void setFamiliaresACargo(Integer familiaresACargo) {
		this.familiaresACargo = familiaresACargo;
	}
}
