package pl.coderslab.datamodel.reports;

import java.sql.Timestamp;

public class RepairInfoByEmployee {
    public RepairInfoByEmployee() {
    }

    private int id;
    private Timestamp repairStartDate;
    private String defectDescription;
    private String repairDescription;
    private String status;
    private String model;
    private String brand;
    private String registrationNo;
    private int repairHours;
    private int repairCost;
    private String nameRepairman;
    private String surnameRepairman;

    public RepairInfoByEmployee(int id, Timestamp repairStartDate, String defectDescription, String repairDescription, String status, String model, String brand, String registrationNo, int repairHours, int repairCost, String name, String surname) {
        this.id = id;
        this.repairStartDate = repairStartDate;
        this.defectDescription = defectDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.model = model;
        this.brand = brand;
        this.registrationNo = registrationNo;
        this.repairHours = repairHours;
        this.repairCost = repairCost;
        this.nameRepairman = name;
        this.surnameRepairman = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Timestamp repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public int getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(int repairHours) {
        this.repairHours = repairHours;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public String getNameRepairman() {
        return nameRepairman;
    }

    public void setNameRepairman(String nameRepairman) {
        this.nameRepairman = nameRepairman;
    }

    public String getSurnameRepairman() {
        return surnameRepairman;
    }

    public void setSurnameRepairman(String surnameRepairman) {
        this.surnameRepairman = surnameRepairman;
    }
}
