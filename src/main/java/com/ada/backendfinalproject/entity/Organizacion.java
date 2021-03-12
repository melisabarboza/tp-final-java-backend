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
	private Integer idOrganizacion;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "cuil")
	Integer cuil;

	@Column(name = "tipo")
	Integer Tipo;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

	public Integer getTipo() {
		return Tipo;
	}

	public void setTipo(Integer tipo) {
		Tipo = tipo;
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
}
