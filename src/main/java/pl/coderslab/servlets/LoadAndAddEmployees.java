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

@WebServlet(name = "LoadAndAddEmployees", urlPatterns = "/employees")
public class LoadAndAddEmployees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Validation moved to front

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phone_number");
        int phoneNoAsInt = 0;
        if (!"".equals(phoneNo) && phoneNo.length() <= 9) {
            phoneNoAsInt = Integer.parseInt(phoneNo);
        }
        String note = request.getParameter("note");
        String wage = request.getParameter("wage");
        int wageAsInt = 0;
        if (!"".equals(wage)) {
            wageAsInt = Integer.parseInt(wage);
        }
        if ((!"".equals(name)) && (!"".equals(surname)) && (!"".equals(address)) && (!"".equals(phoneNo)) && (!"".equals(note)) && (!"".equals(wage))) {

            Employee employee = new Employee(name, surname, address, phoneNoAsInt, note, wageAsInt);
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.create(employee);
            if (employee.getId() != 0) {
                request.setAttribute("message", "success");
                doGet(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
            }
        } else {
            request.setAttribute("message", "invalid_inputs");
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employees = EmployeeDao.readAll();
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);
    }
}
