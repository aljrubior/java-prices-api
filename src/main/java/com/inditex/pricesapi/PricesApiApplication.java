package com.inditex.pricesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class PricesApiApplication {

	private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";

	public static void main(String[] args) {
		SpringApplication.run(PricesApiApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat(DATE_FORMAT));

		return builder;
	}
}
