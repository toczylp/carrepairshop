package pl.coderslab.servlets;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.datamodel.Client;
import pl.coderslab.datamodel.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "CarEdit", urlPatterns = "/car_edit")
public class CarEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String productionYear = request.getParameter("production_year");
        String registrationNo = request.getParameter("registration_no");
        String nextInspection = request.getParameter("next_inspection");
        String clientId = request.getParameter("client_id");

        int idAsInt = 0;
        if (!"".equals(id)) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        int clientIdAsInt = 0;
        if (!"".equals(clientId)) {
            clientIdAsInt = Integer.parseInt(clientId);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        int productionYearAsInt = 0;
        if (!"".equals(productionYear)) {
            productionYearAsInt = Integer.parseInt(productionYear);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        if (registrationNo.length() < 6) {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        Date nextInspectionAsDate = null;
        if (!("".equals(nextInspection))) {
            nextInspectionAsDate = Date.valueOf(nextInspection);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        Vehicle vehicle = new Vehicle(idAsInt, model, brand, productionYearAsInt, registrationNo, nextInspectionAsDate, clientIdAsInt );
        VehicleDao vehicleDao = new VehicleDao();
        boolean updateFlag = vehicleDao.update(vehicle);

        if (updateFlag) {
            loadCars(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idAsInt = 0;

        if (id != null) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.readById(idAsInt);;
        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/WEB-INF/car_edit.jsp").forward(request, response);
    }

    protected void loadCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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