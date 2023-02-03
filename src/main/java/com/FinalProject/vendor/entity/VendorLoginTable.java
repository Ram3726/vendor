package com.FinalProject.vendor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vendor_login_table") // Creating login Table
public class VendorLoginTable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer Id;

    @Column(name= "login_Type")
    private String loginType;

    @Column(name = "vendor_username")
    private String email;

    @Column(name = "vendor_password")
    private String password;


  /*  // Mapping VendorRegTable entity with VendorLogin entity
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="vend_id")
    private VendorRegistrationTable vendorRegistrationTable;*/

}
