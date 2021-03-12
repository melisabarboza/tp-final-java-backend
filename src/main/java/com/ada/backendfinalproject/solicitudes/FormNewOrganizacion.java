package com.ada.backendfinalproject.solicitudes;

public class FormNewOrganizacion {

	Integer idOrganizacion;
	String nombreOrg;
	Integer cuilOrg;
	Integer TipoOrg;
	String direcciónOrg;
	String categoríaOrg;
	Integer añoDeFundacionOrg;
	Integer numeroDeContacto;
	Integer idRepresentanteOrg;

	public String getNombreOrg() {
		return nombreOrg;
	}

	public void setNombreOrg(String nombreOrg) {
		this.nombreOrg = nombreOrg;
	}

	public Integer getCuilOrg() {
		return cuilOrg;
	}

	public void setCuilOrg(Integer cuilOrg) {
		this.cuilOrg = cuilOrg;
	}

	public Integer getTipoOrg() {
		return TipoOrg;
	}

	public void setTipoOrg(Integer tipoOrg) {
		TipoOrg = tipoOrg;
	}

	public String getDirecciónOrg() {
		return direcciónOrg;
	}

	public void setDirecciónOrg(String direcciónOrg) {
		this.direcciónOrg = direcciónOrg;
	}

	public String getCategoríaOrg() {
		return categoríaOrg;
	}

	public void setCategoríaOrg(String categoríaOrg) {
		this.categoríaOrg = categoríaOrg;
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

	public Integer getIdRepresentanteOrg() {
		return idRepresentanteOrg;
	}

	public void setIdRepresentanteOrg(Integer idRepresentanteOrg) {
		this.idRepresentanteOrg = idRepresentanteOrg;
	}
}
