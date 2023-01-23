package com.FinalProject.vendor.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "VendorReg_Info")
public class VendorRegistrationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "vendor_Id")
    private Integer id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    //@Column(name = "company_Name")
    // private String companyName;

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

    //@Column(name = "operating_City")
    //private String operatingCity;

    @Column(name = "license_Number")
    private String licenseNumber;

    @Column(name = "Business_Registration_No")
    private String BusinessRegistrationNo;

    @Column(name = "status")
    private String status;

}