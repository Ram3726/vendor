package com.FinalProject.vendor.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorRegModel {
    //F NAME, L NAME, Company Name, ADDRESS, EMAIL, PHONE, PASSWORD, Confirm password, Operating City

    private String firstName;
    private String lastName;
    //private String companyName;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    //private String operatingCity;
    private String licenseNumber;
    private String businessRegistrationNo;
    private String status;
}
