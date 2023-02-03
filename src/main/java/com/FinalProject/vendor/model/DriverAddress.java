package com.FinalProject.vendor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class DriverAddress {

    private String city;
    private String country;
    private String pin;
}
