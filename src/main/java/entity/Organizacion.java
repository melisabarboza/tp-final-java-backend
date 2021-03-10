package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrganizacion;

	@Column(name = "nombre_org")
	String nombreOrg;

	@Column(name = "cuil_org")
	Integer cuilOrg;

	@Column(name = "tipo_org")
	Integer TipoOrg;

	@Column(name = "direccion_org")
	String direcciónOrg;

	@Column(name = "categoria_org")
	String categoríaOrg;

	@Column(name = "año_fundacion")
	Integer añoDeFundacionOrg;

	@Column(name = "numero_contacto_org")
	Integer numeroDeContacto;

	@Column(name = "id_representante_org")
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
