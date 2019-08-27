package pl.coderslab.servlets;

import pl.coderslab.dao.ReportPLDao;
import pl.coderslab.dao.ReportSalaryDao;
import pl.coderslab.datamodel.reports.ReportProfitLoss;
import pl.coderslab.datamodel.reports.ReportSalary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "Reports", urlPatterns = "/reports")
public class Reports extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reportType =  request.getParameter("report_type");

        String dateStart = request.getParameter("start_date");
        Timestamp dateStartAsTimestamp = null;

        if (!"".equals(dateStart)) {
            dateStartAsTimestamp = Timestamp.valueOf(dateStart + " 08:00:00");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        String dateEnd = request.getParameter("end_date");
        Timestamp dateEndAsTimestamp = null;

        if (!"".equals(dateEnd)) {
            dateEndAsTimestamp = Timestamp.valueOf(dateEnd + " 08:00:00");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/error/data_base_access_error.html").forward(request, response);
        }
        if (dateStartAsTimestamp.after(dateEndAsTimestamp)) {
            request.setAttribute("message", "invalid_inputs");
            getServletContext().getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);
        }

        request.setAttribute("start", dateStart);
        request.setAttribute("end", dateEnd);

        switch (reportType) {
            case "salary_report" :

                ReportSalaryDao reportSalaryDao = new ReportSalaryDao();
                ArrayList<ReportSalary> salary_report = reportSalaryDao.readAll(dateStartAsTimestamp, dateEndAsTimestamp);
                request.setAttribute("report", salary_report);
                getServletContext().getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);

                break;

            case "profit_loss_report" :

                ReportPLDao reportPLDao = new ReportPLDao();
                ReportProfitLoss profitLoss = reportPLDao.readAll(dateStartAsTimestamp, dateEndAsTimestamp);
                request.setAttribute("reportPL", profitLoss);
                getServletContext().getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);
                break;

                default:
                    System.out.println("bliżej niezidentyfikowany błąd");
                    break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/report.jsp").forward(request, response);
    }
}
