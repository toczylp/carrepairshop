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

@WebServlet(name = "CarCreate", urlPatterns = "/car_assign")
public class CarCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String productionYear = request.getParameter("production_year");
        String registrationNo = request.getParameter("registration_no");
        String nextInspectionDate = request.getParameter("next_inspection");
        String clientId = request.getParameter("client_id");

        int productionYearAsInt = 0;

        if (!"".equals(productionYear)) {
            productionYearAsInt = Integer.parseInt(productionYear);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        int clientIdAsInt = 0;

        if (!"".equals(clientId)) {
            clientIdAsInt = Integer.parseInt(clientId);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        Date nextInspecionDateAsDate = null;

        if (!"".equals(nextInspectionDate)) {
            nextInspecionDateAsDate = Date.valueOf(nextInspectionDate);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = new Vehicle(model, brand, productionYearAsInt, registrationNo, nextInspecionDateAsDate, clientIdAsInt);

        vehicle = vehicleDao.create(vehicle);

        if (vehicle.getVehicalId() != 0) {

            ClientDao clientDao = new ClientDao();
            ArrayList<Client> clients = clientDao.readAll();

            if (!clients.isEmpty()) {

                request.setAttribute("clients", clients);
                getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);

            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientIdAsString = request.getParameter("id");
        int clientId = 0;
        if (!"".equals(clientIdAsString)) {
            clientId = Integer.parseInt(clientIdAsString);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        request.setAttribute("id", clientId);
        getServletContext().getRequestDispatcher("/WEB-INF/vehical_create.jsp").forward(request, response);
    }
}
