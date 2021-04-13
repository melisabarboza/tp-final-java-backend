package com.ada.backendfinalproject.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.entity.enums.RolUsuario;

public class UserDetailsMapper {

	public static UserDetails build(Usuario user) {
		return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getContraseña(),
				getAuthorities(user));
	}

	private static Set<? extends GrantedAuthority> getAuthorities(Usuario retrievedUser) {
		RolUsuario rol = retrievedUser.getRol();

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));

		return authorities;
	}
}