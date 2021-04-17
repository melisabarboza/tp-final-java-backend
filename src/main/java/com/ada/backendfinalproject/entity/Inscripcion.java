package com.ada.backendfinalproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Integer idInscripcion;

	@ManyToOne(fetch = FetchType.EAGER)
	private Participante participante;

	@ManyToOne(fetch = FetchType.EAGER)
	private Curso curso;

	@Column(name = "solicita_beca")
	Boolean solicitaBeca;

	@Column(name = "porcentaje_beca")
	Integer porcentajeBeca;

	@Column(name = "estado_inscripcion")
	String estadoInscripcion;

	public Inscripcion() {

	}

	public Inscripcion(Integer idInscripcion, Curso curso, Participante participante, Boolean solicitaBeca,
			Integer porcentajeBeca, String estadoInscripcion) {
		super();
		this.idInscripcion = idInscripcion;
		this.curso = curso;
		this.participante = participante;
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

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
