package com.thecodeveal.app;

public class DataPost {
    public String amount;
    public String currency;
    public String email;
    public String name;
    public String number;
    public String reason;

    public DataPost(String amount, String currency, String email, String name, String number, String reason) {
        this.amount = amount;
        this.currency = currency;
        this.email = email;
        this.name = name;
        this.number = number;
        this.reason = reason;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "DataPost{" +
                "amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}


