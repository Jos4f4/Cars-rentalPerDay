package com.project.carsrentalday.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.carsrentalday.entities.Cars;

@Component
@FeignClient(name = "cars", path = "/cars")
public interface CarsFeignClients {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cars> findById(@PathVariable Long id);
}