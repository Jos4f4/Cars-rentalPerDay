package com.project.cars.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cars.entities.Cars;
import com.project.cars.repositories.CarsRepository;

/*@RestController
@RequestMapping(value = "/cars")
public class CarsResource {

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
@Service
public class CarsResource {
		
	private Logger logger = LoggerFactory.getLogger(CarsResource.class);
		
	@Autowired
	CarsRepository repository;

	public List<Cars> findAll() {

		logger.info("Finding all cars!");

		return repository.findAll();
	}

	public Cars findById(Long id) {
			
		logger.info("Finding one car!");
			
		return repository.findById(id)
			.orElseThrow();
	}
		
	public Cars create(Cars cars) {

		logger.info("Creating one car!");
			
		return repository.save(cars);
	}
		
	public Cars update(Cars cars) {
			
		logger.info("Updating one car!");
			
		var entity = repository.findById(cars.getId())
			.orElseThrow();

		((Cars) entity).setMarca(cars.getMarca());  
		((Cars) entity).setModelo(cars.getModelo());
		((Cars) entity).setCor(cars.getCor());
		((Cars) entity).setPlaca(cars.getPlaca());
		((Cars) entity).setRentalDay(cars.getRentalDay());
			
		return repository.save(cars);
	}
		
	public void delete(Long id) {
			
		logger.info("Deleting one car!");
			
		var entity = repository.findById(id)
				.orElseThrow();
		repository.delete(entity);
	}
}


