package com.gar;

import com.gar.controllers.CarController;
import com.gar.data.DB;
import com.gar.data.interfaces.IDB;
import com.gar.repositories.interfaces.ICarRepository;
import com.gar.repositories.CarRepository;

public class Main
{
    public static void main(String[] args)
    {
        IDB db = new DB();
        ICarRepository repo = new CarRepository(db);
        CarController controller = new CarController(repo);
        Application app = new Application(controller);
        app.start();
    }
}
