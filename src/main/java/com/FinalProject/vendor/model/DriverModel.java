package com.FinalProject.vendor.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DriverModel {


    private String driverId;
    private String driverName;

    private String phoneNo;
    private String drivingLicense;


    private String vendorId;

    private List<Address> address;







}
