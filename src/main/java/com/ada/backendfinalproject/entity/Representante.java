package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Representante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idRepresentante;

	@Column(name = "id_organizacion")
	Integer idOrganizacion;

	@Column(name = "nombre_apellido")
	String nombreApellido;

	@Column(name = "dni")
	Long dni;

	@Column(name = "cargo")
	String cargo;

	@Column(name = "email")
	String email;

	public Representante(Integer idRepresentante, Integer idOrganizacion, String nombreApellido, Long dni, String cargo,
			String email) {
		super();
		this.idRepresentante = idRepresentante;
		this.idOrganizacion = idOrganizacion;
		this.nombreApellido = nombreApellido;
		this.dni = dni;
		this.cargo = cargo;
		this.email = email;
	}

	public Integer getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Integer idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
