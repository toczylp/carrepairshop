package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.datamodel.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RemoveEmployee", urlPatterns = "/remove_employee")
public class RemoveEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employees = EmployeeDao.readAll();
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idAsInt = 0;

        if (!(id == null)) {
            idAsInt = Integer.parseInt(id);
        } else {
            response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
        }
        EmployeeDao employeeDao = new EmployeeDao();
        boolean deleteFlag = employeeDao.delete(idAsInt);

        if (deleteFlag) {
            request.setAttribute("message", "success");
        } else {
            request.setAttribute("message", "fail");
        }

        doPost(request, response);
    }
}
