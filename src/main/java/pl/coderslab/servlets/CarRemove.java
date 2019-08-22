package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.datamodel.Employee;
import pl.coderslab.datamodel.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarRemove", urlPatterns = "/car_remove")
public class CarRemove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VehicleDao vehicleDao = new VehicleDao();
        ArrayList<Vehicle> vehicles = vehicleDao.readAll();
        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/cars.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idAsInt = 0;

        if (!(id == null)) {
            idAsInt = Integer.parseInt(id);
        } else {
            response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
        }
        VehicleDao vehicleDao = new VehicleDao();
        boolean deleteFlag = vehicleDao.delete(idAsInt);

        if (deleteFlag) {
            request.setAttribute("message", "success");
        } else {
            request.setAttribute("message", "fail");
        }
        doPost(request, response);
    }
}

