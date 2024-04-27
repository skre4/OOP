package com.example.third.controller;
import com.example.third.DbHandler;
import com.example.third.model.Car;
import com.example.third.service.CarService;
import com.example.third.service.idCar;
import com.google.gson.Gson;
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
@WebServlet("/delete")
public class deleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        StringBuffer json = new StringBuffer();
        CarService carService = new CarService();
        String line = null;
        BufferedReader reader = request.getReader();
        DbHandler dbHandler = new DbHandler();
        String str = reader.readLine();
        str = str.substring(1, str.length() - 1);
        dbHandler.deleteCar(Integer.parseInt(str));
        System.out.println("del");
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json1 = "{\"success\":\"success\"}";
        pw.println(json1.toString());
        pw.flush();
// System.out.println("записано "+json);
    }
}
