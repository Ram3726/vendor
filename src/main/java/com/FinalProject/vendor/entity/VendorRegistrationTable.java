package com.FinalProject.vendor.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VendorRegistrationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "company_Name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_Number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_Password")
    private String confirmPassword;

    @Column(name = "operating_City")
    private String operatingCity;


}
