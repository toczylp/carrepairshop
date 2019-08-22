package pl.coderslab.datamodel;

import java.sql.Date;

public class Vehicle {

    private int vehicalId;
    private String model;
    private String brand;
    private int productionYear;
    private String registrationNo;
    private Date nextInspectionDate;
    private int clientId = 0;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, int productionYear, String registrationNo, Date nextInspectionDate, int clientId) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNo = registrationNo;
        this.nextInspectionDate = nextInspectionDate;
        this.clientId = clientId;
    }

    public Vehicle(String model, String brand, int productionYear, String registrationNo, Date nextInspectionDate) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNo = registrationNo;
        this.nextInspectionDate = nextInspectionDate;
    }

    public Vehicle(int vehicalId, String model, String brand, int productionYear, String registrationNo, Date nextInspectionDate, int clientId) {
        this.vehicalId = vehicalId;
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

    public Date getNextInspectionDate() {
        return nextInspectionDate;
    }

    public void setNextInspectionDate(Date nextInspectionDate) {
        this.nextInspectionDate = nextInspectionDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}


