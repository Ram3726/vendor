package com.FinalProject.vendor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "VendorLogin_table") // Creating login Table

public class VendorLoginTable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer LoginId;

    @Column(name= "login_Type")
    private String loginType;

    @Column(name = "vendor_username")
    private String loginEmail;

    @Column(name = "vendor_password")
    private String loginPassword;


    /*// Mapping VendorRegTable entity with VendorLogin entity
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY, orphanRemoval = true)
    @MapsId
    @JoinColumn(name="vend_id")
    private VendorRegistrationTable vendorRegistrationTable;*/


}
