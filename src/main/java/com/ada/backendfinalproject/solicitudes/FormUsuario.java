package com.ada.backendfinalproject.solicitudes;

import com.ada.backendfinalproject.entity.enums.RolUsuario;

public class FormUsuario {

	String usuario;
	String contraseña;
	RolUsuario rol;

	public RolUsuario getRol() {
		return rol;
	}

	public void setRol(RolUsuario rol) {
		this.rol = rol;
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
}
