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
import java.util.ArrayList;

@WebServlet(name = "ClientRemove", urlPatterns = "/remove_client")
public class ClientRemove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDao clientDao = new ClientDao();
        ArrayList<Client> clients = clientDao.readAll();
        request.setAttribute("clients", clients);
        getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int idAsInt = 0;

        if (!(id == null)) {
            idAsInt = Integer.parseInt(id);
        } else {
            response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
        }
        ClientDao clientDao = new ClientDao();
        boolean deleteFlag = clientDao.delete(idAsInt);

        if (deleteFlag) {
            request.setAttribute("message", "success");
        } else {
            request.setAttribute("message", "fail");
        }

        doPost(request, response);
    }
}
