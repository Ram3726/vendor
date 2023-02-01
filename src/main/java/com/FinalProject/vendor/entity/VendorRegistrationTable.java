package com.FinalProject.vendor.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "VendorReg_Info")
public class VendorRegistrationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "login_type")
    private String loginType;

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

    @Column(name = "license_Number")
    private String licenseNumber;

    @Column(name = "Business_Registration_No")
    private String businessRegistrationNo;

    @Column(name = "status")
    private String status;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true) // mapping vendorReg table with LoginTable
    @JoinColumn(name = "login_id")
   private VendorLoginTable vendorLoginTable;  //( Either of one way is good to mapping for login and VendReg table)

}

