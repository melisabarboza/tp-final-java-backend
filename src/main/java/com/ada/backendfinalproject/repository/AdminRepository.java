package com.ada.backendfinalproject.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

	Optional<Admin> findByUsuarioAndContraseña(String usuario, String contraseña);

}
