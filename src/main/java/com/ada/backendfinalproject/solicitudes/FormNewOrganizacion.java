package com.ada.backendfinalproject.solicitudes;

public class FormNewOrganizacion {

	Integer idOrganizacion;
	String nombreOrg;
	Long cuilOrg;
	Integer tipoOrg;
	String direccionOrg;
	String categoriaOrg;
	Integer añoDeFundacionOrg;
	Integer numeroDeContacto;
	Integer idRepresentanteOrg;
	String estadoOrganizacion = "pendiente aprobacion";

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

	public Integer getIdRepresentanteOrg() {
		return idRepresentanteOrg;
	}

	public void setIdRepresentanteOrg(Integer idRepresentanteOrg) {
		this.idRepresentanteOrg = idRepresentanteOrg;
	}

	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getEstadoOrganizacion() {
		return estadoOrganizacion;
	}

	public void setEstadoOrganizacion(String estadoOrganizacion) {
		this.estadoOrganizacion = estadoOrganizacion;
	}
}
