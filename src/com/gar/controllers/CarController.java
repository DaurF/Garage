package com.gar.controllers;

import com.gar.entities.Car;
import com.gar.repositories.interfaces.ICarRepository;

import java.util.List;

public class CarController
{
    private final ICarRepository repo;

    public CarController(ICarRepository repo) { this.repo = repo; }

    public String createCar(int id, String car_name, String car_model, int release_year, int mileage, String car_color, String steering_wheel, int price)
    {
        Car car = new Car(id, car_name, car_model, release_year, mileage, car_color, steering_wheel, price);

        boolean created = repo.createCar(car);

        return(created ? "Car was added successfully!" : "Error while adding car");
    }

    public String getCar(int id)
    {
        Car car = repo.getCar(id);

        return (car == null ? "Unfortunately, car wasn't found" : car.toString());
    }

    public String getAllCars()
    {
        List<Car> garagetable = repo.getAllCars();

        return garagetable.toString();
    }

}
