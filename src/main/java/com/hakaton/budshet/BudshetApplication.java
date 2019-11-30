package com.hakaton.budshet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class BudshetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudshetApplication.class, args);
	}

	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.parse("10000KB"));
		factory.setMaxRequestSize(DataSize.parse("10000KB"));
		return factory.createMultipartConfig();
	}

}
