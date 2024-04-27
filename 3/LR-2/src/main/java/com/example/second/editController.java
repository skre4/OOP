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
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/edit")
public class editController extends HttpServlet {
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
// json.insert(1,dm+"id"+dm+":"+dm+ idCar.id+dm+",");
        }
        Car car = carService.writeCar(json.toString());
// System.out.println(json.toString());
        DbHandler dbHandler = new DbHandler();
        dbHandler.editCar(car.getId(),car.getStamp(), car.getModel(), car.getGeneration(), car.getYear(),
                car.getPrice());
//
        PrintWriter pw = response.getWriter();
//
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        pw.println(json.toString());
        pw.flush();
        System.out.println("записано "+json);
    }
}