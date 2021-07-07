package com.thecodeveal.app;

import com.flutterwave.rave.java.entry.mobileMoney;
import com.flutterwave.rave.java.payload.mobilemoneyPayload;

import java.net.UnknownHostException;

public class payments {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Payments");

        mobileMoney mobileMoney = new mobileMoney();
        mobilemoneyPayload mobilemoneyPayload = new mobilemoneyPayload();
        mobilemoneyPayload.setPBFPubKey("FLWPUBK-4e581ebf8372cd691203b27227e2e3b8-X");
        mobilemoneyPayload.setCurrency("UGX");
        mobilemoneyPayload.setAmount("2000");
        mobilemoneyPayload.setPhonenumber("256752331807");
        mobilemoneyPayload.setEmail("kanyeallan@gmail.com");
        mobilemoneyPayload.setFirstname("temi");
        mobilemoneyPayload.setLastname("desola");
        mobilemoneyPayload.setNetwork("AIRTEL");
        mobilemoneyPayload.setMetaname("extra info");
        mobilemoneyPayload.setCountry("UG");
        mobilemoneyPayload.setMetavalue("a pie");
//        mobilemoneyPayload.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
        mobilemoneyPayload.setPayment_type("mobilemoneyuganda");
        mobilemoneyPayload.setEncryption_key("6b0ec0713e277b68e667f6cc");
        mobilemoneyPayload.setPublic_key("FLWPUBK-6790074903692e260195911c502ffc98-X");
//if split payment set subaccount values

        System.out.println("Mobile money Request: " + mobilemoneyPayload.toString());

        String response = mobileMoney.domobilemoney(mobilemoneyPayload);

        System.out.println("Response: "+response);
    }

}
