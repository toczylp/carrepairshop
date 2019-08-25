package pl.coderslab.servlets;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.ReportBaiscDao;
import pl.coderslab.datamodel.Order;
import pl.coderslab.datamodel.reports.ReportBasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "RepairUpdate", urlPatterns = "/update_repair_record")
public class RepairUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
