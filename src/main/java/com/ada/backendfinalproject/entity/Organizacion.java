package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idOrganizacion;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "cuil")
	Long cuil;

	@Column(name = "tipo")
	Integer tipo;

	@Column(name = "direccion")
	String direccion;

	@Column(name = "categoria")
	String categoria;

	@Column(name = "año_fundacion")
	Integer añoDeFundacion;

	@Column(name = "numero_contacto")
	Integer numeroDeContacto;

	@Column(name = "id_representante")
	Integer idRepresentante;

	@Column(name = "estado_organizacion")
	String estadoOrganizacion;

	public Organizacion() {

	}

	public Organizacion(Integer idOrganizacion, String nombre, Long cuil, Integer tipo, String direccion,
			String categoria, Integer añoDeFundacion, Integer numeroDeContacto, Integer idRepresentante,
			String estadoOrganizacion) {
		super();
		this.idOrganizacion = idOrganizacion;
		this.nombre = nombre;
		this.cuil = cuil;
		this.tipo = tipo;
		this.direccion = direccion;
		this.categoria = categoria;
		this.añoDeFundacion = añoDeFundacion;
		this.numeroDeContacto = numeroDeContacto;
		this.idRepresentante = idRepresentante;
		this.estadoOrganizacion = estadoOrganizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAñoDeFundacion() {
		return añoDeFundacion;
	}

	public void setAñoDeFundacion(Integer añoDeFundacion) {
		this.añoDeFundacion = añoDeFundacion;
	}

	public Integer getNumeroDeContacto() {
		return numeroDeContacto;
	}

	public void setNumeroDeContacto(Integer numeroDeContacto) {
		this.numeroDeContacto = numeroDeContacto;
	}

	public Integer getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(Integer idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public String getEstadoOrganizacion() {
		return estadoOrganizacion;
	}

	public void setEstadoOrganizacion(String estadoOrganizacion) {
		this.estadoOrganizacion = estadoOrganizacion;
	}
}
