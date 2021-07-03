package com.thecodeveal.app.gcc.Models;

import javax.persistence.*;

@Entity
@Table(name = "donatemobile")
public class DonateMobileMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String number;
    @Column(name = "amount")
    private String amount;
    @Column(name = "success")
    private Boolean success;

    public DonateMobileMoney() {

    }

    public DonateMobileMoney(String name, String email, String number, String amount, Boolean success) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.amount = amount;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
