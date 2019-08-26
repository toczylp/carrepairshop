package pl.coderslab.datamodel;

import java.sql.Timestamp;

public class Order {

    private int id;
    private Timestamp repairStartDatePlanned;
    private Timestamp repairStartDate;
    private int assignedRepairmanId;
    private String defectDescription;
    private String repairDescription;
    private String status = "receiving";
    private int vehicalId;
    private int repairCost = 0;
    private int partsCost = 0;
    private int wageHourly = 0;
    private int repairHours = 0;

    public Order() {
    }

    public Order(Timestamp repairStartDatePlanned, String defectDescription, String repairDescription, String status, int vehicalId) {
        this.repairStartDatePlanned = repairStartDatePlanned;
        this.defectDescription = defectDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicalId = vehicalId;
    }

    public Order(Timestamp repairStartDatePlanned, int assignedRepairmanId, String defectDescription, int vehicalId, int wage) {
        this.repairStartDatePlanned = repairStartDatePlanned;
        this.assignedRepairmanId = assignedRepairmanId;
        this.defectDescription = defectDescription;
        this.vehicalId = vehicalId;
        this.wageHourly = wage;
    }

    public Order(
            Timestamp repairStartDatePlanned, Timestamp repairStartDate, int assignedRepairmanId, String defectDescription,
            String repairDescription, String status, int vehicalId, int partsCost, int wageHourly, int repairHours) {
        this.repairStartDatePlanned = repairStartDatePlanned;
        this.repairStartDate = repairStartDate;
        this.assignedRepairmanId = assignedRepairmanId;
        this.defectDescription = defectDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicalId = vehicalId;
        this.repairCost = partsCost + repairHours * wageHourly;
        this.partsCost = partsCost;
        this.wageHourly = wageHourly;
        this.repairHours = repairHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAssignedRepairmanId() {
        return assignedRepairmanId;
    }

    public void setAssignedRepairmanId(int assignedRepairmanId) {
        this.assignedRepairmanId = assignedRepairmanId;
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

    public int getVehicalId() {
        return vehicalId;
    }

    public void setVehicalId(int vehicalId) {
        this.vehicalId = vehicalId;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost() {
        this.repairCost = this.wageHourly * this.repairHours + this.partsCost;
    }

    public void setRepairCost(int partsCost, int repairHours, int wageHourly) {
        this.repairCost = 2 * partsCost + 2 * repairHours * wageHourly;
    }

    public int getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(int partsCost) {
        this.partsCost = partsCost;
    }

    public int getWageHourly() {
        return wageHourly;
    }

    public void setWageHourly(int wageHourly) {
        this.wageHourly = wageHourly;
    }

    public int getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(int repairHours) {
        this.repairHours = repairHours;
    }
}
