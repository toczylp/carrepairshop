package pl.coderslab.servlets;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.datamodel.Client;
import pl.coderslab.datamodel.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "ClientEdit", urlPatterns = "/client_edit")
public class ClientEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        int idAsInt = 0;
        if (!(id == null)) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String dateOfBirth = request.getParameter("date_of_birth");
        String mail = request.getParameter("mail");
        Date dateOfBirthAsDate = null;
        if (!("".equals(dateOfBirth))) {
            dateOfBirthAsDate = Date.valueOf(dateOfBirth);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        Client client = new Client(idAsInt, name, surname, dateOfBirthAsDate, mail);

        ClientDao clientDao = new ClientDao();

        boolean updateFlag = clientDao.update(client);
        if (updateFlag) {
            ArrayList<Client> clients = clientDao.readAll();

            if (!clients.isEmpty()) {
                request.setAttribute("clients", clients);
                getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);

            } else {
                response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idAsInt = 0;

        if (!(id == null)) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.readById(idAsInt);
        //System.out.println(employee.getWageHourly());

        request.setAttribute("client", client);
        getServletContext().getRequestDispatcher("/WEB-INF/client_edit.jsp").forward(request, response);
    }
}