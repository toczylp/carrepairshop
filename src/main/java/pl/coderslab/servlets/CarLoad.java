package pl.coderslab.servlets;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.datamodel.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarLoad", urlPatterns = "/car_load")
public class CarLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VehicleDao vehicleDao = new VehicleDao();
        ArrayList<Vehicle> vehicles = vehicleDao.readAll();
        if (!vehicles.isEmpty()) {
            request.setAttribute("vehicles", vehicles);
            getServletContext().getRequestDispatcher("/WEB-INF/cars.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }
}
