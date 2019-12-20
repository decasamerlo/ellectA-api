package br.com.decasamerlo.ellectA.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ellecta")
public class EllectAProperty {

	private String originPermitida = "http://localhost:4200";

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

}
