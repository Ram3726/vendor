package com.FinalProject.vendor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "Login_table")

public class LoginTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LoginId;

    @Column(name = "login_email")
    private String loginEmail;

    @Column(name = "login_password")
    private String loginPassword;

  //  @OneToOne(cascade = CascadeType.ALL)
  //  private VendorRegistrationTable vendorRegistrationTable;//mapping vendorReg table





}
