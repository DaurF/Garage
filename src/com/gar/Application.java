package com.gar;

import com.gar.controllers.CarController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application
{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final CarController controller;
    private final Scanner sc;

    public Application(CarController controller)
    {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void start()
    {
        while(true)
        {
            System.out.println("*****************************************");
            System.out.print("** ");
            System.out.print(ANSI_GREEN + "Welcome to the garage!" + ANSI_RESET);
            System.out.println(" **");
            System.out.println("*****************************************");
            System.out.println("** 1. Get a list of all cars         **");
            System.out.println("** 2. Get a car by id                **");
            System.out.println("** 3. Add car                        **");
            System.out.println("** 0. Exit                           **");
            System.out.println("*****************************************");

            try
            {
                System.out.println(ANSI_RED + "Select the desired option (1-3):          " + ANSI_RESET);
                int option = sc.nextInt();
                if(option == 1)
                {
                    getAllCarsMenu();
                }
                else if(option == 2)
                {
                    getCarByIdMenu();
                }
                else if(option == 3)
                {
                    createCarMenu();
                }
                else
                    break;
            } catch (InputMismatchException c)
            {
                System.out.println("The number must be an integer");
                sc.nextLine();
            } catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllCarsMenu()
    {
        String response = controller.getAllCars();
        System.out.println(response);
    }

    public void getCarByIdMenu()
    {
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        String response = controller.getCar(id);
        System.out.println(response);
    }

    public void createCarMenu()
    {
        System.out.println("Please, enter ID: ");
        int id = sc.nextInt();
        System.out.println("Enter car name: ");
        String car_name = sc.next();
        System.out.println("Enter car_model: ");
        String car_model = sc.next();
        System.out.println("Enter release year: ");
        int release_year = sc.nextInt();
        System.out.println("Enter mileage: ");
        int mileage = sc.nextInt();
        System.out.println("Enter color: ");
        String car_color = sc.next();
        System.out.println("Enter steering wheel: ");
        String steering_wheel = sc.next();
        System.out.println("Enter price");
        int price = sc.nextInt();

        String response = controller.createCar(id, car_name, car_model, release_year, mileage, car_color, steering_wheel, price);
        System.out.println(response);
    }
}
