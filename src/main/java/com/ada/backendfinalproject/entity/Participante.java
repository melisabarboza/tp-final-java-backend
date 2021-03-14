package com.ada.backendfinalproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idParticipante;

	@Column(name = "nombre_apellido")
	String nombreApellido;

	@Column(name = "fn")
	Date fn;

	@Column(name = "genero")
	String genero;

	@Column(name = "domicilio")
	String domicilio;

	@Column(name = "estudia")
	Boolean estaEstudiando;

	@Column(name = "trabaja")
	Boolean estaTrabajando;

	@Column(name = "tiene_ingresos")
	Boolean tieneIngresos;

	@Column(name = "ingreso_mensual")
	Integer ingresoMensual;

	@Column(name = "cantidad_familiares_a_cargo")
	Integer familiaresACargo;

	public Participante() {

	}

	public Participante(Integer idParticipante, String nombreApellido, Date fn, String genero, String domicilio,
			boolean estaEstudiando, boolean estaTrabajando, boolean tieneIngresos, Integer ingresoMensual,
			Integer familiaresACargo) {
		super();
		this.idParticipante = idParticipante;
		this.nombreApellido = nombreApellido;
		this.fn = fn;
		this.genero = genero;
		this.domicilio = domicilio;
		this.estaEstudiando = estaEstudiando;
		this.estaTrabajando = estaTrabajando;
		this.tieneIngresos = tieneIngresos;
		this.ingresoMensual = ingresoMensual;
		this.familiaresACargo = familiaresACargo;

	}

	public Boolean DatosSocioEconomicosCargados() {

		if (this.estaEstudiando != null && this.estaTrabajando != null && this.tieneIngresos != null
				&& this.familiaresACargo != null) {
			return true;
		}
		return false;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Date getFn() {
		return fn;
	}

	public void setFn(Date fn) {
		this.fn = fn;
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

	public Integer getFamiliaresACargo() {
		return familiaresACargo;
	}

	public void setFamiliaresACargo(Integer familiaresACargo) {
		this.familiaresACargo = familiaresACargo;
	}
}
