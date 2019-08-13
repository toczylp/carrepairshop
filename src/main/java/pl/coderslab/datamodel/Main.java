package pl.coderslab.datamodel;

// Class for testing DAO

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;

import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {

        Timestamp dOb = Timestamp.valueOf("1991-01-21 05:12:44");

        Timestamp nId = Timestamp.valueOf("2020-01-21 05:12:44");

        //Order order = new Order(nId, 1, "Nie dzialaja hamulce",1);

        OrderDao orderDao = new OrderDao();

        Order order = orderDao.readById(1);

        order.setRepairStartDate(nId);
        order.setRepairHours(20);
        order.setWageHourly(100);
        order.setPartsCost(1100);
        order.setRepairCost();
        order.setStatus("ready to pick up");
        order.setRepairDescription("wymiana tarcz i klockow hamulcowych");

        orderDao.update(order);


        /*
        Vehicle vehicle = new Vehicle("700", "Fiat", 2001, "GA1111", nId, 1);

        System.out.println(vehicle.getClientId());

        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.create(vehicle);*/

/*
        Employee employee = new Employee("Jan", "Kowaslki", "Warszawa, Potokowa 21", 554322111, "bardzo dobry pracownik", 123);
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.create(employee);
*/

        //Vehicle vehicle = new Vehicle("600", "Fiat", 1995, "WU084V", nId, 1);
       /* VehicleDao vehicleDao = new VehicleDao();
        System.out.println(vehicleDao.delete(2));
*/
        //vehicleDao.create(vehicle);
  //      Client client = new Client("Marek", "Marecki", dOb, "marecki@op.pl");

/*        ClientDao clientDao = new ClientDao();

        ArrayList<Client> clients = clientDao.readAll();

        for (Client client:
             clients) {

            System.out.println(client.getId());
            System.out.println(client.getName());
            System.out.println(client.getSurname());
            System.out.println(client.getDateOfBirth());
            System.out.println(client.getMail());
            System.out.println("*********************************");

        }*/




    }
}
