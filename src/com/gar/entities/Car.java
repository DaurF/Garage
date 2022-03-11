package com.gar.entities;

public class Car
{
    // Some car properties

    private int id;
    private String car_name;
    private String car_model;
    private int release_year;
    private int mileage;
    private String car_color;
    private String steering_wheel;
    private int price;

    public Car() {};

    public Car(String name, String model, int release_year, int mileage, String color, String wheel, int price)
    {
        setName(name);
        setModel(model);
        setYear(release_year);
        setMileage(mileage);
        setColor(color);
        setWheel(wheel);
        setPrice(price);
    }

    public Car(int id, String name, String model, int release_year, int mileage, String color, String wheel, int price)
    {
        setId(id);
        setName(name);
        setModel(model);
        setYear(release_year);
        setMileage(mileage);
        setColor(color);
        setWheel(wheel);
        setPrice(price);
    }

    // Setters

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        car_name = name;
    }

    public void setModel(String model)
    {
        car_model = model;
    }

    public void setYear(int year)
    {
        release_year = year;
    }

    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }

    public void setColor(String color)
    {
        car_color = color;
    }

    public void setWheel(String wheel)
    {
        steering_wheel = wheel;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    // Getters

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return car_name;
    }

    public String getModel()
    {
        return car_model;
    }

    public int getYear()
    {
        return release_year;
    }

    public int getMileage()
    {
        return mileage;
    }

    public String getColor()
    {
        return car_color;
    }

    public String getWheel()
    {
        return steering_wheel;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return "[-- ID = " + id + "\nCar name: " + car_name + "\nCar model: " + car_model + "\nRelease year: " + release_year + "\nMileage: " + mileage + "\nColor: " + car_color + "\nSteering wheel: " + steering_wheel + "\nPrice: " + price + " --]";
    }
}
