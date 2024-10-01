# Cars-rentalPerDay
 About CRUD de aluguel de carros por diária, baseado na arquitetura de microsserviços Java 11 e Spring Boot.
#CARS
http://localhost:8765/cars/cars
http://localhost:8765/cars/cars/1
#PAYMENTS
http://localhost:8765/cars-rentalday/payments/1/days/10

#CREATE
http://localhost:8765/cars/cars
{
    "marca": "Ferrari",
    "modelo": "Ferrari LaFerrari",
    "cor": "Vermelha",
    "placa": "BRA-2024",
    "rentalDay": 10.0
}
#UPDATE
http://localhost:8765/cars/carshttp://localhost:8765/cars/cars
{
    "id": 4,
    "marca": "Ferrari",
    "modelo": "Ferrari @LaFerrari",
    "cor": "Vermelha",
    "placa": "BRA-2024-2025",
    "rentalDay": 10.0
}
#DELETE
http://localhost:8765/cars/cars/4

#SWAGGER
http://localhost:{PORTA}/v3/api-docs
http://localhost:{PORTA}/swagger-ui.html

#EUREKA http://localhost:8761
#DB localhost:{PORTAcars}/db-cars
