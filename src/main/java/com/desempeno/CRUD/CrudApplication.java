package com.desempeno.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //Declara que sea una aplicación de spring boot
@EnableJpaAuditing // Sirve para auditorias, es decir, cuando se crea o actualiza algo en la BD
@EnableJpaRepositories //Permite que podamos leer data.sql
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
