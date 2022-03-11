package com.gar.data;

import com.gar.data.interfaces.IDB;
import java.sql.*;

public class DB implements IDB
{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/garagedb";
        try
        {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "rxVVrs3y6AUyqHxd");

            return con;
        } catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
