package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.RepairInfoByEmployeeDao;
import pl.coderslab.datamodel.Employee;
import pl.coderslab.datamodel.reports.RepairInfoByEmployee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReadRepairInfoByRepairmanId", urlPatterns = "/repair_by_repairman")
public class ReadRepairInfoByRepairmanId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println();

        int idAsInt = 0;

        if (!("".equals(id))) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        RepairInfoByEmployeeDao repairInfoByEmployeeDao = new RepairInfoByEmployeeDao();
        ArrayList<RepairInfoByEmployee> repairInfo = repairInfoByEmployeeDao.readById(idAsInt);

        if (!repairInfo.isEmpty()) {
            request.setAttribute("repair_info", repairInfo);
            getServletContext().getRequestDispatcher("/WEB-INF/repair_info_by_employee.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "no_repair");
            EmployeeDao employeeDao = new EmployeeDao();
            ArrayList<Employee> employees = EmployeeDao.readAll();
            request.setAttribute("employees", employees);
            getServletContext().getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);
        }
    }

}
