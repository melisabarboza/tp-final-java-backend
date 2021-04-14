package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Representante {

	@Id
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	private Usuario usuario;

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

	public Representante() {

	}

	public Representante(Usuario usuario, Integer idOrganizacion, String nombreApellido, Long dni, String cargo,
			String email) {
		super();
		this.idOrganizacion = idOrganizacion;
		this.usuario = usuario;
		this.nombreApellido = nombreApellido;
		this.dni = dni;
		this.cargo = cargo;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setUsuarioId(Integer id) {
		this.id = id;
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
