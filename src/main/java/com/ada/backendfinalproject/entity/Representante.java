package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Representante {

	@Id
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	Organizacion organizacion;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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

	public Representante(Usuario usuario, Organizacion organizacion, String nombreApellido, Long dni, String cargo,
			String email) {
		super();
		this.organizacion = organizacion;
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

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
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
