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
    @Column (name = "vendor_Id")
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

    //@Column(name = "operating_City")
    //private String operatingCity;

    @Column(name = "license_Number")
    private String licenseNumber;

    @Column(name = "Business_Registration_No")
    private String BusinessRegistrationNo;

    @Column(name = "status")
    private String status;

    //@OneToOne (cascade = CascadeType.ALL) //one to one mapping
      //private VendorLoginTable vendorLoginTable;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true) // mapping vendorReg table with LoginTable
    @JoinColumn(name = "vendor_role_id")
    private List<VendorRolesTable> rolesList;
    private VendorLoginTable loginTable;  //( Either of one way is good to mapping for login and VendReg table)

}

