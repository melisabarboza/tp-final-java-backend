package com.ada.backendfinalproject.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ada.backendfinalproject.entity.Usuario;
import com.ada.backendfinalproject.entity.enums.RolUsuario;
import com.ada.backendfinalproject.repository.UsuarioRepository;
import com.ada.backendfinalproject.solicitudes.FormUsuario;

import security.UserDetailsMapper;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public UserDetails loadUsuarioByUsuario(String usuario) {
		Optional<Usuario> user = usuarioRepository.findByUsuario(usuario);

		if (user == null) {
			throw new UsernameNotFoundException("usuario o contraseña invalidas");
		}

		return UserDetailsMapper.build(user.get());

	}

	public Usuario addNew(FormUsuario solicitud) {
		Usuario user = new Usuario(0, solicitud.getUsuario(), solicitud.getContraseña(), solicitud.getRol());
		return usuarioRepository.save(user);
	}

	public Optional<Usuario> getUsuarioBy(String usuario, String contraseña) {
		return usuarioRepository.findByUsuarioAndContraseña(usuario, contraseña);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);
		if (usuario.isPresent()) {
			return new org.springframework.security.core.userdetails.User(usuario.get().getUsuario(),
					usuario.get().getContraseña(), getAuthorities(usuario.get()));
		} else {
			throw new UsernameNotFoundException("usuario incorrecto");
		}
	}

	public UserDetails getUserDetailsByUser(Usuario usuario) {
		return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getContraseña(),
				getAuthorities(usuario));

	}

	private static Set<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
		RolUsuario rol = usuario.getRol();

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));

		return authorities;
	}

}
