package pl.coderslab.servlets;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.datamodel.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "ClientAdd", urlPatterns ="/add_client")
public class ClientAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String dOb = request.getParameter("date_of_birth");
        String email = request.getParameter("mail");
        Date dObAsDate = null;
        if (!("".equals(dOb))) {
            dObAsDate = Date.valueOf(dOb);
        }
        // Simple validation + database create record

        if (!("".equals(name)) && !("".equals(surname)) && !(dObAsDate.equals(Date.valueOf(LocalDate.now()))) && (dObAsDate != null)) {

            Client client = new Client(name, surname, dObAsDate, email);
            ClientDao clientDao = new ClientDao();
            client = clientDao.create(client);
            if (client.getId() != 0) {

                request.setAttribute("message", "success");
                getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);
                ;
            } else {

                getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
            }
        } else {
            request.setAttribute("message", "invalid_inputs");
            getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDao clientDao = new ClientDao();
        ArrayList<Client> clients = clientDao.readAll();

        if (!clients.isEmpty()) {

            request.setAttribute("clients", clients);
            getServletContext().getRequestDispatcher("/WEB-INF/add_client.jsp").forward(request, response);

        } else {
            response.sendRedirect("/WEB-INF/error/data_base_access_error.html");
        }
    }
}
