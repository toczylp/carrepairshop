package pl.coderslab;

import pl.coderslab.dao.EmployeeDao;

import java.sql.Date;

public class Main1 {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.delete(5);

        String date = "2011-11-12";

        Date dateAsDate = Date.valueOf(date);
        System.out.println(dateAsDate);
    }
}
