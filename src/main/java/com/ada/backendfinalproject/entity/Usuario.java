package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idUsuario;

	@Column(name = "usuario")
	String usuario;

	@Column(name = "contraseña")
	String contraseña;

	@Column(name = "rol")
	String rol;

	public Usuario(Integer idUsuario, String usuario, String contraseña, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
