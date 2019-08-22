package pl.coderslab.servlets;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.ReportBaiscDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.datamodel.Client;
import pl.coderslab.datamodel.Employee;
import pl.coderslab.datamodel.Vehicle;
import pl.coderslab.datamodel.reports.ReportBasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RepairLoad", urlPatterns = "/repair_load")
public class RepairLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ReportBaiscDao reportBaiscDao = new ReportBaiscDao();
        ArrayList<ReportBasic> repairs = reportBaiscDao.readAll();
        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employees = employeeDao.readAll();
        VehicleDao vehicleDao = new VehicleDao();
        ArrayList<Vehicle> vehicles = vehicleDao.readAll();

        if (!repairs.isEmpty()) {
            request.setAttribute("employees", employees);
            request.setAttribute("repair_info", repairs);
            request.setAttribute("vehicles", vehicles);
            getServletContext().getRequestDispatcher("/WEB-INF/repair_info.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }
}
