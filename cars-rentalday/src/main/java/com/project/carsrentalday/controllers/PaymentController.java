package com.project.carsrentalday.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.carsrentalday.entities.Payment;
import com.project.carsrentalday.services.PaymentServiceFeign;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cars-RenatlDay endpoint")
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
	
	@Autowired
	private PaymentServiceFeign service;
	
	@Operation(summary = "Payment = days * rentalday + ((rentalday*20/100)*days")
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{carsId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long carsId, @PathVariable Integer days){
		Payment payment = service.getPayment(carsId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long carsId, Integer days){
		Payment payment = new Payment("MARCA", "MODELO", "COR", "PLACA", 10.0, days);
		return ResponseEntity.ok(payment);
	}
}