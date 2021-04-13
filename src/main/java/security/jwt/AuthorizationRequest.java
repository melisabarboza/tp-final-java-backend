package security.jwt;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationRequest implements Serializable {

	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("contraseña")
	private String contraseña;

	public AuthorizationRequest() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}