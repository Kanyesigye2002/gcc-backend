package com.thecodeveal.app.gcc.Models;

import javax.persistence.*;

@Entity
@Table(name = "donatecreditCard")
public class DonateCreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "amount")
    private String amount;
    @Column(name = "payment")
    private String payment;
    @Column(name = "acc_no")
    private String acc_no;
    @Column(name = "acc_name")
    private String acc_name;
    @Column(name = "ccv")
    private String ccv;
    @Column(name = "success")
    private Boolean success;

    public DonateCreditCard() {

    }

    public DonateCreditCard(String name, String email, String amount, String payment, String acc_no, String acc_name, String ccv, Boolean success) {
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.payment = payment;
        this.acc_no = acc_no;
        this.acc_name = acc_name;
        this.ccv = ccv;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
