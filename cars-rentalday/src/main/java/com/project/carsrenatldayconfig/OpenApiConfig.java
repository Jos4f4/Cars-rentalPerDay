package com.project.carsrenatldayconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info =
@Info(title = "Cars RentalDay Project",
		version  = "v1",
		description = "Documentation of payment cars"))
@Configuration
public class OpenApiConfig{
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.components(new Components())
			.info(
				new io.swagger.v3.oas.models.info.Info()
				.title("Cars RentalDay Project")
				.version("v1")
				.description("Documentation of payment cars")
				.termsOfService("https://pub.erudio.com.br/meus-cursoshtp")
				.license(
					new License()
						.name("Apache 2.0.1")
						.url("https://pub.erudio.com.br/microserviceshtp")
				)
			);
	}

}