package pl.coderslab.datamodel;

// Class for testing DAO

import pl.coderslab.dao.VehicleDao;

import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {

        Timestamp dOb = Timestamp.valueOf("1991-01-21 05:12:44");

        Timestamp nId = Timestamp.valueOf("2020-01-21 05:12:44");

        //Vehicle vehicle = new Vehicle("600", "Fiat", 1995, "WU084V", nId, 1);
        VehicleDao vehicleDao = new VehicleDao();
        System.out.println(vehicleDao.delete(2));

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
