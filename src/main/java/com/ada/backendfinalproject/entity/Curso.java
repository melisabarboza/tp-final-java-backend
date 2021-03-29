package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "descripcion")
	String descripcion;

	@Column(name = "modalidad")
	String modalidad;

	@Column(name = "costo")
	Integer costo;

	@Column(name = "horas")
	Integer horas;

	@Column(name = "categoria")
	String categoria;

	@Column(name = "numero_participantes")
	Integer numeroParticipantes;

	@Column(name = "becas_disponibles")
	Integer becasDisponibles;

	@Column(name = "id_organizacion")
	Integer idOrganizacion;

	public Curso() {

	}

	public Curso(Integer id, String nombre, String descripcion, String modalidad, Integer costo, Integer horas,
			String categoria, Integer numeroParticipantes, Integer becasDisponibles, Integer idOrganizacion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.costo = costo;
		this.horas = horas;
		this.categoria = categoria;
		this.numeroParticipantes = numeroParticipantes;
		this.becasDisponibles = becasDisponibles;
		this.idOrganizacion = idOrganizacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripciion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getCategoría() {
		return categoria;
	}

	public void setCategoría(String categoría) {
		this.categoria = categoría;
	}

	public Integer getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(Integer numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public Integer getBecasDisponibles() {
		return becasDisponibles;
	}

	public void setBecasDisponibles(Integer becasDisponibles) {
		this.becasDisponibles = becasDisponibles;
	}

	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public void restarBeca() {
		this.becasDisponibles--;
	}

	public void restarVacante() {
		this.numeroParticipantes--;
	}

}
