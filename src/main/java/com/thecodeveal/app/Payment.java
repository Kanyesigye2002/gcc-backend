package com.thecodeveal.app;

import com.flutterwave.rave.java.entry.mobileMoney;
import com.flutterwave.rave.java.payload.mobilemoneyPayload;

public class Payment {

    public String response;

    public Payment(String amount, String name, String email, String number) {
        try {

            mobileMoney mobileMoney = new mobileMoney();
            mobilemoneyPayload mobilemoneyPayload = new mobilemoneyPayload();
            mobilemoneyPayload.setAmount(amount);
            mobilemoneyPayload.setPhonenumber(number);
            mobilemoneyPayload.setEmail(email);
            mobilemoneyPayload.setFirstname(name);
            mobilemoneyPayload.setPayment_type("mobilemoneyuganda");
            mobilemoneyPayload.setCountry("NG");
            mobilemoneyPayload.setNetwork("UGX");
            mobilemoneyPayload.setCurrency("UGX");
            mobilemoneyPayload.setMetaname("info");
            mobilemoneyPayload.setMetavalue("Glorious Church Uganda");
            mobilemoneyPayload.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
            mobilemoneyPayload.setEncryption_key("5b495b280e8bfe9db30a4da6");
            mobilemoneyPayload.setPBFPubKey("FLWPUBK-cdd7983b5eb1571a8d32ddcbac9ba277-X");
            mobilemoneyPayload.setPublic_key("FLWPUBK-cdd7983b5eb1571a8d32ddcbac9ba277-X");

            String response = mobileMoney.domobilemoney(mobilemoneyPayload);

            System.out.println("Response: "+response);

            this.response = response;
        } catch (Exception e) {
            e.printStackTrace();
            this.response = e.getMessage();
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}


//    com.flutterwave.rave.java.entry.mobileMoney mobileMoney = new mobileMoney();
//    com.flutterwave.rave.java.payload.mobilemoneyPayload mobilemoneyPayload = new mobilemoneyPayload();
//        mobilemoneyPayload.setPBFPubKey("FLWPUBK-cdd7983b5eb1571a8d32ddcbac9ba277-X");
//                mobilemoneyPayload.setCurrency("UGX");
//                mobilemoneyPayload.setAmount("2000");
//                mobilemoneyPayload.setPhonenumber("256752331807");
//                mobilemoneyPayload.setEmail("kanyeallan@gmail.com");
//                mobilemoneyPayload.setFirstname("temi");
//                mobilemoneyPayload.setLastname("desola");
//                mobilemoneyPayload.setNetwork("UGX");
////        mobilemoneyPayload.setNetwork("AIRTEL");
//                mobilemoneyPayload.setMetaname("extra info");
//                mobilemoneyPayload.setCountry("NG");
//                mobilemoneyPayload.setMetavalue("a pie");
////        mobilemoneyPayload.setIs_mobile_money_ug(1);
//                mobilemoneyPayload.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
//                mobilemoneyPayload.setPayment_type("mobilemoneyuganda");
//                mobilemoneyPayload.setEncryption_key("5b495b280e8bfe9db30a4da6");
//                mobilemoneyPayload.setPublic_key("FLWPUBK-cdd7983b5eb1571a8d32ddcbac9ba277-X");
////if split payment set subaccount values
//
//                System.out.println("Mobile money Request: " + mobilemoneyPayload);
//
//                String response = mobileMoney.domobilemoney(mobilemoneyPayload);
////        String responses = mobileMoney.domobilemoney(mobilemoneyPayload);
//
//                System.out.println("Response: "+response);