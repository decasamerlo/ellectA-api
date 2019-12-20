package br.com.decasamerlo.ellectA.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.decasamerlo.ellectA.api.config.EllectAProperty;

@SpringBootApplication
@EnableConfigurationProperties(EllectAProperty.class)
public class EllectAApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EllectAApiApplication.class, args);
	}

}
