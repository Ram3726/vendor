package com.FinalProject.vendor.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class CarRegistrationPkId implements Serializable {



    private String carRegistration;

    private  Integer vendorId;


}
