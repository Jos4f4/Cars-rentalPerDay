package com.project.cars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cars.entities.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}