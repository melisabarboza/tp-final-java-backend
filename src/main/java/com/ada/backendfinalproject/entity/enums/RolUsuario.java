package com.ada.backendfinalproject.entity.enums;

public enum RolUsuario {
	ADMIN(1), PARTICIPANTE(2), REPRESENTANTE(3);

	private int value;

	private RolUsuario(int value) {
		this.value = value;
	}
}