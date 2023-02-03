package com.FinalProject.vendor.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverModel {
    private String driverId;
    private String name;
    private String phone;
    private String driverLicenceNumber;
    private String photo;

    private int vendorId;

    private DriverAddress driverAddress;


}
