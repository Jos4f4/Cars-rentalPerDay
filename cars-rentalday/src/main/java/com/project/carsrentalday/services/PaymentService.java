package com.project.carsrentalday.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carsrentalday.entities.Cars;
import com.project.carsrentalday.entities.Payment;
import com.project.carsrentalday.feignclients.CarsFeignClients;

@Service
public class PaymentService {
	
	//@Value("${cars.host}")
	//private String carsHost;

	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private CarsFeignClients carsFeignClient;
	
	public Payment getPayment(long carsId, int days) {
		//return new Payment(("MARCA", "MODELO", "COR", "PLACA", 100.0, 10);
		
		//Map<String, String> uriVariables = new HashMap<>();
		//uriVariables.put("id", ""+carsId);
		
		Cars cars = carsFeignClient.findById(carsId).getBody();
		return new Payment(cars.getMarca(), cars.getModelo(), cars.getCor(), cars.getPlaca(), cars.getRentalDay(), days);
	}
}

