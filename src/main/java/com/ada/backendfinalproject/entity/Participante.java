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
	private Integer idParticipante;

	@Column(name = "nombre_apellido")
	String nombreApellido;

	@Column(name = "fecha_nacimiento")
	Date fechaDeNacimiento;

	@Column(name = "genero")
	String género;

	@Column(name = "domicilio")
	String domicilio;

	@Column(name = "esta_estudiando")
	boolean estaEstudiando;

	@Column(name = "esta_trabajando")
	boolean estaTrabajando;

	@Column(name = "tiene_ingresos")
	boolean tieneIngresos;

	@Column(name = "ingreso_mensual")
	Integer ingresoMensual;

	@Column(name = "tiene_familia_cargo")
	boolean tieneFamiliaACargo;

	@Column(name = "cantidad_familiares_cargo")
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

	public String getGénero() {
		return género;
	}

	public void setGénero(String género) {
		this.género = género;
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
