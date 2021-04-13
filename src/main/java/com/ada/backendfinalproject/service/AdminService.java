package com.ada.backendfinalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Admin;
import com.ada.backendfinalproject.repository.AdminRepository;
import com.ada.backendfinalproject.solicitudes.FormAdmin;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public Admin addNew(FormAdmin solicitud) {

		Admin usuario = new Admin(0, solicitud.getUsuario(), solicitud.getContraseña());

		adminRepository.save(usuario);
		return usuario;

	}

	// get
	public Optional<Admin> getAuthUser(String usuario, String contraseña) {
		return adminRepository.findByUsuarioAndContraseña(usuario, contraseña);
	}

}
