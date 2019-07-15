package pl.coderslab.datamodel;

import java.sql.Timestamp;

public class Vehicle {

    private int vehicalId;
    private String model;
    private String brand;
    private int productionYear;
    private String registrationNo;
    private Timestamp nextInspectionDate;
    private int clientId;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, int productionYear, String registrationNo, Timestamp nextInspectionDate, int clientId) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNo = registrationNo;
        this.nextInspectionDate = nextInspectionDate;
        this.clientId = clientId;
    }

    public int getVehicalId() {
        return vehicalId;
    }

    public void setVehicalId(int vehicalId) {
        this.vehicalId = vehicalId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Timestamp getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(Timestamp nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
