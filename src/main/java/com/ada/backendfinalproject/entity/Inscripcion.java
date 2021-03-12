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
	Integer idInscripcion;

	@Column(name = " abona_costo_total")
	String abonaCostoTotal;
	@Column(name = " solicita_beca")
	String solicitaBeca;

	public String getAbonaCostoTotal() {
		return abonaCostoTotal;
	}

	public void setAbonaCostoTotal(String abonaCostoTotal) {
		this.abonaCostoTotal = abonaCostoTotal;
	}

	public String getSolicitaBeca() {
		return solicitaBeca;
	}

	public void setSolicitaBeca(String solicitaBeca) {
		this.solicitaBeca = solicitaBeca;
	}

}
