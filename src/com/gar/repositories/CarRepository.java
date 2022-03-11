package com.gar.repositories;

import com.gar.data.interfaces.IDB;
import com.gar.entities.Car;
import com.gar.repositories.interfaces.ICarRepository;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class CarRepository implements ICarRepository {
    private final IDB db;

    public CarRepository(IDB db)
    {
        this.db = db;
    }

    @Override
    public boolean createCar(Car car)
    {
        Connection con = null;
        try
        {
            con = db.getConnection();
            String sql = "INSERT INTO garagetable(id, car_name, car_model, release_year, mileage, car_color, steering_wheel, price) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, car.getId());
            st.setString(2, car.getName());
            st.setString(3, car.getModel());
            st.setInt(4, car.getYear());
            st.setInt(5, car.getMileage());
            st.setString(6, car.getColor());
            st.setString(7, car.getWheel());
            st.setInt(8, car.getPrice());

            st.execute();
            return true;
        } catch(SQLException throwables)
        {
            throwables.printStackTrace();
        } catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                con.close();
            } catch(SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Car getCar(int id)
    {
        Connection con = null;
        try
        {
            con = db.getConnection();
            String sql = "SELECT id, car_name, car_model, release_year, mileage, car_color, steering_wheel, price FROM garagetable WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                Car car = new Car(rs.getInt("id"), rs.getString("car_name"), rs.getString("car_model"), rs.getInt("release_year"), rs.getInt("mileage"), rs.getString("car_color"), rs.getString("steering_wheel"), rs.getInt("price"));
                return car;
            }
        } catch(SQLException throwables)
        {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally {
            try
            {
                con.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Car> getAllCars()
    {
        Connection con = null;
        try
        {
            con = db.getConnection();
            String sql = "SELECT id, car_name, car_model, release_year, mileage, car_color, steering_wheel, price FROM garagetable";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Car> garagetable = new LinkedList<>();
            while(rs.next())
            {
                Car car = new Car(rs.getInt("id"), rs.getString("car_name"), rs.getString("car_model"), rs.getInt("release_year"), rs.getInt("mileage"), rs.getString("car_color"), rs.getString("steering_wheel"), rs.getInt("price"));
                garagetable.add(car);
            }

            return garagetable;
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally {
            try
            {
                con.close();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
