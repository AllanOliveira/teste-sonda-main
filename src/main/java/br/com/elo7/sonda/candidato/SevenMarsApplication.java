package br.com.elo7.sonda.candidato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class SevenMarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SevenMarsApplication.class, args);
	}

}
