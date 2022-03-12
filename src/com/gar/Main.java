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
        String connectionUrl = "jdbc:postgresql://localhost:5432/garagedb";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        // Here we load the driver’s class file into memory at the runtime
        Class.forName("org.postgresql.Driver");

        // Establish the connection
        con = DriverManager.getConnection(connectionUrl, "postgres", "rxVVrs3y6AUyqHxd");

        // The object of statement is responsible to execute queries with the database
        stmt = con.createStatement();

        // The executeQuery() method of Statement interface is used to execute queries
        // to the database. This method returns the object of ResultSet that can be
        // used to get all the records of a table that matches the sql statement
        rs = stmt.executeQuery("select * from garagetable");

        while (rs.next()) // Processing the result
            System.out.println(rs.getInt("id") + "  "
                    + rs.getString("car_name"));


        System.out.println("Finished!");

        IDB db = new DB();
        ICarRepository repo = new CarRepository(db);
        CarController controller = new CarController(repo);
        Application app = new Application(controller);
        app.start();
    }
}
