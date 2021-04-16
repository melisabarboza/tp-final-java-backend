package com.ada.backendfinalproject.solicitudes;

import com.ada.backendfinalproject.entity.enums.EstadoOrganizacion;

public class FormNewOrganizacion {

	String nombreOrg;
	Long cuilOrg;
	Integer tipoOrg;
	String direccionOrg;
	String categoriaOrg;
	Integer añoDeFundacionOrg;
	Integer numeroDeContacto;

	String estadoOrganizacion = EstadoOrganizacion.PENDIENTE.name();

	public String getNombreOrg() {
		return nombreOrg;
	}

	public void setNombreOrg(String nombreOrg) {
		this.nombreOrg = nombreOrg;
	}

	public Long getCuilOrg() {
		return cuilOrg;
	}

	public void setCuilOrg(Long cuilOrg) {
		this.cuilOrg = cuilOrg;
	}

	public Integer getTipoOrg() {
		return tipoOrg;
	}

	public void setTipoOrg(Integer tipoOrg) {
		this.tipoOrg = tipoOrg;
	}

	public String getDireccionOrg() {
		return direccionOrg;
	}

	public void setDireccionOrg(String direcciónOrg) {
		this.direccionOrg = direcciónOrg;
	}

	public String getCategoriaOrg() {
		return categoriaOrg;
	}

	public void setCategoriaOrg(String categoríaOrg) {
		this.categoriaOrg = categoríaOrg;
	}

	public Integer getAñoDeFundacionOrg() {
		return añoDeFundacionOrg;
	}

	public void setAñoDeFundacionOrg(Integer añoDeFundacionOrg) {
		this.añoDeFundacionOrg = añoDeFundacionOrg;
	}

	public Integer getNumeroDeContacto() {
		return numeroDeContacto;
	}

	public void setNumeroDeContacto(Integer numeroDeContacto) {
		this.numeroDeContacto = numeroDeContacto;
	}

	public String getEstadoOrganizacion() {
		return estadoOrganizacion;
	}

	public void setEstadoOrganizacion(String estadoOrganizacion) {
		this.estadoOrganizacion = estadoOrganizacion;
	}
}
