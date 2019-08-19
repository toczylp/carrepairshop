package pl.coderslab.datamodel;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String address;
    private int phoneNo;
    private String note;
    private int wageHourly;

    public Employee() {
    }

    public Employee(String name, String surname, String address, int phoneNo, String note, int wageHourly) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNo = phoneNo;
        this.note = note;
        this.wageHourly = wageHourly;
    }

    public Employee(int id, String name, String surname, String address, int phoneNo, String note, int wageHourly) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNo = phoneNo;
        this.note = note;
        this.wageHourly = wageHourly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getWageHourly() {
        return wageHourly;
    }

    public void setWageHourly(int wageHourly) {
        this.wageHourly = wageHourly;
    }
}
