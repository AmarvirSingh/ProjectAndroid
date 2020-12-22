package com.example.projectandroid;


public class CustomerDetails {
    private String  cNumber;
    private String password;
    private  int accountNumber;
    private String mail;
    private String name;
    private String type;
    private String address;
    private String phone;
    private double amount;

    public CustomerDetails(String cNumber, String password, int accountNumber, String mail, String name, String type, String address, String phone, double amount) {
        this.cNumber = cNumber;
        this.password = password;
        this.accountNumber = accountNumber;
        this.mail = mail;
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.amount = amount;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}