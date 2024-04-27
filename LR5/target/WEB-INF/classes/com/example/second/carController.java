package com.example.third.controller;
import com.example.third.DbHandler;
import com.example.third.model.Car;
import com.example.third.service.CarService;
import com.example.third.service.idCar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/car")
public class CarController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("UTF-8");
        CarService carService = new CarService();
// File file = new File(getServletContext().getRealPath("/")+"car.json");
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.getCars();
        String json = "[";
        try {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(1));
                car.setStamp(resultSet.getString(2));
                car.setModel(resultSet.getString(3));
                car.setGeneration(resultSet.getString(4));
                car.setYear(resultSet.getString(5));
                car.setPrice(resultSet.getInt(6));
                json += carService.getCar(car);
                json = json.substring(0, json.length() - 1);
                json += ",\"button\":\"<button value='" + car.getId() + "' class='btn btndanger'>Delete</button><br><br><button value='" + car.getId() + "' class='btn btn-info' data-toggle='modal'
                data-target='#carModalEdit' >Edit</button> \" " + "},";
// json += "";
// System.out.println(json);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
// String json=carService.getCar(file);
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json = json.substring(0, json.length() - 1);
        json += "]";
        pw.println(json);
        pw.flush();
        System.out.println("прочитано " + json );
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        CarService carService = new CarService();
// File file = new File(getServletContext().getRealPath("/")+"car.json");
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        final char dm = (char) 34;
        while((line=reader.readLine())!=null) {
            json.append(line);
            json.insert(1,dm+"id"+dm+":"+dm+ idCar.id+dm+",");
        }
        Car car = carService.writeCar(json.toString());
        System.out.println(json.toString());
        DbHandler dbHandler = new DbHandler();
        dbHandler.setCar(car.getStamp(), car.getModel(), car.getGeneration(), car.getYear(), car.getPrice());
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        pw.println(json.toString());
        pw.flush();
// System.out.println("записано "+json);
    }
}