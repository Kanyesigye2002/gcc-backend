//package com.thecodeveal.app.gcc.Models;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Getter
//@Setter
//@Entity(name = "Team")
//@Table(name = "Team")
//public class Team {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "USER_NAME", unique = true)
//    private String userName;
//
//    @Column(name = "CREATED_ON")
//    private Date createdAt = new Date();
//
//    @Column(name = "UPDATED_ON")
//    private Date updatedAt;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "second_name")
//    private String secondName;
//
//    @Column(name = "image")
//    private String image;
//
//    @Column(name = "enabled")
//    private boolean enabled=true;
//}
