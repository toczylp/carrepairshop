package pl.coderslab.servlets;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.datamodel.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmployees", urlPatterns = "/employees_edit")
public class EditEmployees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
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

        Employee employee = new Employee(id, name, surname, address, phoneNoAsInt, note, wageAsInt);
        EmployeeDao employeeDao = new EmployeeDao();
        boolean updateFlag = employeeDao.update(employee);
        if (updateFlag) {
            getServletContext().getRequestDispatcher("/employees").forward(request, response);
        } else {
            response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
        }
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
        Employee employee = employeeDao.readById(idAsInt);
        System.out.println(employee.getWageHourly());

        request.setAttribute("employee", employee);
        getServletContext().getRequestDispatcher("/WEB-INF/employee_edit.jsp").forward(request, response);
    }
}