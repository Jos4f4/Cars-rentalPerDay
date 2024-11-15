package com.project.carsrentalday.entities;

import java.io.Serializable;

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private Double rentalday;
	private Integer days;
	
	public Payment() {
		
	}

	public Payment(String marca, String modelo, String cor, String placa, Double rentalday, Integer days) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.rentalday = rentalday;
		this.days = days;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getRentalDay() {
		return rentalday;
	}

	public void setRentalDay(Double rentalday) {
		this.rentalday = rentalday;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {	
			this.days = days;
	}

	public Double getTotal() {
		if(days<=0) {
			return -(days * rentalday * 0);
		}
		return days * rentalday + ((rentalday*20/100)*days);
	}
}