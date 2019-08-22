package pl.coderslab.servlets;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.ReportBaiscDao;
import pl.coderslab.datamodel.reports.ReportBasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RepairRemove", urlPatterns = "/delete_repair_record")
public class RepairRemove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportBaiscDao reportBaiscDao = new ReportBaiscDao();
        ArrayList<ReportBasic> repairs = reportBaiscDao.readAll();
        if (!repairs.isEmpty()) {
            request.setAttribute("repair_info", repairs);
            getServletContext().getRequestDispatcher("/WEB-INF/repair_info.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        int idAsInt = 0;
        if (!"".equals(id)) {
            idAsInt = Integer.parseInt(id);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        OrderDao orderDao = new OrderDao();
        boolean deleteFlag = orderDao.delete(idAsInt);

        if (deleteFlag) {
            request.setAttribute("message", "success_del");
        } else {
            request.setAttribute("message", "fail");
        }

        doPost(request, response);
    }
}
