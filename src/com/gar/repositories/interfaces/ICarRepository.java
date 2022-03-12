package com.gar.repositories.interfaces;

import com.gar.entities.Car;

import java.util.List;

public interface ICarRepository
{
    boolean createCar(Car car);
    Car getCar(int id);
    List<Car> getAllCars();
    boolean removeCar(int id);
}
