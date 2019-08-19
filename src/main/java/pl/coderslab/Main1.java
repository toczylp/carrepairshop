package pl.coderslab;

import pl.coderslab.dao.EmployeeDao;

public class Main1 {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.delete(5);
    }
}
