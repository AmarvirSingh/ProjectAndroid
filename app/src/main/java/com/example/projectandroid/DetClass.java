package com.example.projectandroid;

public class DetClass {
    private String number;
    private String detType;
    private String amount;
    private String account;

    public DetClass(String number, String detType, String amount, String account) {
        this.number = number;
        this.detType = detType;
        this.amount = amount;
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDetType() {
        return detType;
    }

    public void setDetType(String detType) {
        this.detType = detType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
