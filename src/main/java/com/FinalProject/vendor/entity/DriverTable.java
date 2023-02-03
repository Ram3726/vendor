package com.FinalProject.vendor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Driver_Info")
public class DriverTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "driver_id")
    private String driverId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "driver_licence_number")
    private String driverLicenceNumber;

    @Column(name = "photo")
    private String photo;

    @Column(name = "vendor_Id")
    private  Integer vendorId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private DriverAddressTable driverAddressTable;

}
