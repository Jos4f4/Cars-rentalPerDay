package com.project.carseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CarsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsEurekaServerApplication.class, args);
	}

}