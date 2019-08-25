package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.ReportBaiscDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.datamodel.Employee;
import pl.coderslab.datamodel.Order;
import pl.coderslab.datamodel.Vehicle;
import pl.coderslab.datamodel.reports.ReportBasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "RepairCreate", urlPatterns = "/repair_create")
public class RepairCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String date = request.getParameter("repair_start_planned");
        Timestamp dateAsTimestamp = null;

        if (!"".equals(date)) {
            dateAsTimestamp = Timestamp.valueOf(date + " 08:00:00");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String vehicleId = request.getParameter("vehicle_id");
        int vehicleIdAsInt = 0;
        if (!"".equals(vehicleId)) {
            vehicleIdAsInt = Integer.parseInt(vehicleId);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String defectDescription = request.getParameter("defect_description");
        String  repairmanId = request.getParameter("repairman_id");
        int repIdAsInt = 0;
        if (!"".equals(repairmanId)) {
            repIdAsInt = Integer.parseInt(repairmanId);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        EmployeeDao employeeDao = new EmployeeDao();
        int wage = employeeDao.readWageById(repIdAsInt);

        Order order = new Order(dateAsTimestamp, repIdAsInt, defectDescription, vehicleIdAsInt, wage);
        OrderDao orderDao = new OrderDao();
        orderDao.carInbound(order);
        ReportBaiscDao reportBaiscDao = new ReportBaiscDao();
        ArrayList<ReportBasic> repairs = reportBaiscDao.readAll();
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
