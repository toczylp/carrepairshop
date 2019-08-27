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
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "RepairUpdate", urlPatterns = "/update_repair_record")
public class RepairUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idAsInt = 0;
        if (!"".equals(id)) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String defDescription = request.getParameter("defect_description");
        String repDescription = request.getParameter("repair_description");
        String partCost = request.getParameter("parts_cost");
        int partCostAsInt = 0;
        if (!"".equals(partCost)) {
            partCostAsInt = Integer.parseInt(partCost);
            if (partCostAsInt <= 0) {
                getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String repairHours = request.getParameter("repair_hours");
        int repairHoursAsInt = 0;
        if (!"".equals(repairHours)) {
            repairHoursAsInt = Integer.parseInt(repairHours);
            if (repairHoursAsInt <= 0) {
                getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String status = request.getParameter("status");
        Timestamp repairStart = Timestamp.valueOf("2019-01-01 00:00:00");
        if ("in repair".equals(status)) {
            repairStart = Timestamp.valueOf(LocalDateTime.now());
        }
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.readById(idAsInt);
        order.setStatus(status);
        order.setRepairDescription(repDescription);
        order.setDefectDescription(defDescription);
        order.setPartsCost(partCostAsInt);
        order.setRepairHours(repairHoursAsInt);
        order.setRepairCost();
        order.setRepairStartDate(repairStart);

        orderDao.update(order);
        boolean updateFlag = orderDao.update(order);
        if (updateFlag) {
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
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String repairId = request.getParameter("id");
        int repairIdAsInt = 0;
        if (!"".equals(repairId)) {
            repairIdAsInt = Integer.parseInt(repairId);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.readById(repairIdAsInt);
        if (order != null) {
            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher("/WEB-INF/repair_update.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }
}
