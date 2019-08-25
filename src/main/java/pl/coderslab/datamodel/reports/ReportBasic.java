package pl.coderslab.datamodel.reports;

import java.sql.Date;
import java.sql.Timestamp;

public class ReportBasic {
    private int id;
    private String repairStatus;
    private Timestamp repairStartDatePlanned;
    private Timestamp repairStartDate;
    private String brand;
    private String model;
    private int productionYear;
    private String registrationNo;
    private Date nextInspection;
    private String defectDescription;
    private String repairDescription;
    private int repairCost;
    private int repairHours;
    private int partsCost;
    private String nameRepairman;
    private String surnameRepairman;
    private int wageHourly;
    private String clientSurname;
    private String clientName;

    public ReportBasic() {
    }

    public ReportBasic(int id, String repairStatus, Timestamp repairStartDatePlanned, Timestamp repairStartDate, String brand, String model, int productionYear, String registrationNo, Date nextInspection, String defectDescription, String repairDescription, int repairCost, int repairHours, int partsCost, String nameRepairman, String surnameRepairman, int wageHourly, String clientSurname, String clientName) {
        this.id = id;
        this.repairStatus = repairStatus;
        this.repairStartDatePlanned = repairStartDatePlanned;
        this.repairStartDate = repairStartDate;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.registrationNo = registrationNo;
        this.nextInspection = nextInspection;
        this.defectDescription = defectDescription;
        this.repairDescription = repairDescription;
        this.repairCost = repairHours * wageHourly + partsCost;
        this.repairHours = repairHours;
        this.partsCost = partsCost;
        this.nameRepairman = nameRepairman;
        this.surnameRepairman = surnameRepairman;
        this.wageHourly = wageHourly;
        this.clientSurname = clientSurname;
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Timestamp getRepairStartDatePlanned() {
        return repairStartDatePlanned;
    }

    public void setRepairStartDatePlanned(Timestamp repairStartDatePlanned) {
        this.repairStartDatePlanned = repairStartDatePlanned;
    }

    public Timestamp getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Timestamp repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Date getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(Date nextInspection) {
        this.nextInspection = nextInspection;
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

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public int getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(int repairHours) {
        this.repairHours = repairHours;
    }

    public int getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(int partsCost) {
        this.partsCost = partsCost;
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

    public int getWageHourly() {
        return wageHourly;
    }

    public void setWageHourly(int wageHourly) {
        this.wageHourly = wageHourly;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

