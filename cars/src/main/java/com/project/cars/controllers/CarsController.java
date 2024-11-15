package com.project.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.cars.entities.Cars;
import com.project.cars.services.CarsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cars project")
@RestController
@RequestMapping("/cars")
public class CarsController{

		@Autowired
		private CarsService service;
		///private CarsResource service = new PersonCarsResource();
		
		@Operation(summary = "Find all cars")
		@RequestMapping(method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Cars> findAll() {
			return service.findAll();
		}
		
		@Operation(summary = "Find a specific car by ID")
		@RequestMapping(value = "/{id}",
				method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Cars findById(@PathVariable(value = "id") Long id) {
			return service.findById(id);
		}
		
		@Operation(summary = "Create car")
		@RequestMapping(method=RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Cars create(@RequestBody Cars cars) {
			return service.create(cars);
		}
		
		@Operation(summary = "Update car")
		@RequestMapping(method=RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Cars update(@RequestBody Cars cars) {
			return service.update(cars);
		}
		
		@Operation(summary = "Delete car")
		@RequestMapping(value = "/{id}",
				method=RequestMethod.DELETE)
		public void delete(@PathVariable(value = "id") Long id) {
			service.delete(id);
		}
}


/*@RestController
@RequestMapping(value = "/cars")
public class CarsController {

		//Balaceamento de carga========
		private static Logger logger = LoggerFactory.getLogger(CarsResource.class);
		@Autowired
		private Environment env;
		////Balaceamento de carga========
		
		@Autowired
		private CarsRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Cars>> findAll(){
			List<Cars> list = repository.findAll();
			return ResponseEntity.ok(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Cars> findById(@PathVariable Long id){
			
			//Balaceamento de carga========
			//logger.info("PORT = " + env.getProperty("local.servr.port"));
			//Balaceamento de carga========
			
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			logger.info("PORT = " + env.getProperty("local.server.port"));
			
			Cars obj = repository.findById(id).get();
			return ResponseEntity.ok(obj);
		}
}*/