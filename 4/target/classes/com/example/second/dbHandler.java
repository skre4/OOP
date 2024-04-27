package com.example.third.service;
import com.example.third.Configs;
import com.example.third.model.Car;
import java.sql.*;
public class DbHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void setCar(String stamp, String model, String generation, String year, int price) {
        String sql = "INSERT INTO cars (stamp, model, generation, year, price) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, stamp);
            prSt.setString(2, model);
            prSt.setString(3, generation);
            prSt.setString(4, year);
            prSt.setInt(5, price);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void editCar(int id, String stamp, String model, String generation, String year, int price) {
        String sql = "UPDATE cars SET stamp = ?, model = ?, generation = ?, year = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, stamp);
            prSt.setString(2, model);
            prSt.setString(3, generation);
            prSt.setString(4, year);
            prSt.setInt(5, price);
            prSt.setInt(6, id);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getCars() {
        String sql = "SELECT * FROM cars";
        ResultSet resultSet = null;
        try {
            Statement statement = getDbConnection().createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE id = ?";
        System.out.println(id);
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setInt(1, id);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
