package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idInscripcion;

	@Column(name = "id_curso")
	Integer idCurso;

	@Column(name = "id_participante")
	Integer idParticipante;

	@Column(name = "solicita_beca")
	Boolean solicitaBeca;

	@Column(name = "porcentaje_beca")
	Integer porcentajeBeca;

	@Column(name = "estado_inscripcion")
	String estadoInscripcion; // pendiente, aprobada, desaprobada

	public Inscripcion(Integer idInscripcion, Integer idCurso, Integer idParticipante, Boolean solicitaBeca,
			Integer porcentajeBeca, String estadoInscripcion) {
		super();
		this.idInscripcion = idInscripcion;
		this.idCurso = idCurso;
		this.idParticipante = idParticipante;
		this.solicitaBeca = solicitaBeca;
		this.porcentajeBeca = porcentajeBeca;
		this.estadoInscripcion = estadoInscripcion;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	public Integer getPorcentajeBeca() {
		return porcentajeBeca;
	}

	public void setPorcentajeBeca(Integer porcentajeBeca) {
		this.porcentajeBeca = porcentajeBeca;
	}

	public Boolean getSolicitaBeca() {
		return solicitaBeca;
	}

	public void setSolicitaBeca(Boolean solicitaBeca) {
		this.solicitaBeca = solicitaBeca;
	}

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}
}
