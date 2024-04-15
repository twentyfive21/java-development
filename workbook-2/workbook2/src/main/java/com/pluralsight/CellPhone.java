package com.pluralsight;

public class CellPhone {
    // set class to private for encapsulation to modify only using setter and getters
    // private String owner;

    int serialNumber;
    String model;
    String carrier;
    private String phoneNumber;
    String owner;

    public CellPhone() {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCarrier() {
        return this.carrier;
    }
    public void setCarrier(String carrier){
        this.carrier = carrier;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void dial (String phoneNumber) {
        System.out.printf("%s phone is calling %s \n", getOwner(), phoneNumber);
    }
    public void dial (CellPhone overloadedUser) {
        System.out.printf("%s phone is calling %s \n", overloadedUser.getOwner(), overloadedUser.getPhoneNumber());
    }
}
