package com.gar;

import com.gar.controllers.CarController;
import com.gar.data.DB;
import com.gar.data.interfaces.IDB;
import com.gar.repositories.interfaces.ICarRepository;
import com.gar.repositories.CarRepository;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        IDB db = new DB();
        ICarRepository repo = new CarRepository(db);
        CarController controller = new CarController(repo);
        Application app = new Application(controller);
        app.start();
    }
}
