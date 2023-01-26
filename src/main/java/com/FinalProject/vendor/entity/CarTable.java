package com.FinalProject.vendor.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@IdClass(CarRegistrationPkId.class)
@Table(name = "Car_Info")
public class CarTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "car_Type")
    private String carType;

    @Column(name = "car_Model")
    private String carModel;

    @Column(name = "car_Seater")
    private String carSeater;

    @Column(name = "baggage_Capacity")
    private String baggageCapacity;

    @Id
    @Column(name = "car_Registration")
    private String carRegistration;

    @Column(name = "car_AC_NonAc")
    private String carACorNonAc;

    @Column(name = "base_Price")
    private double basePrice;

    @Column(name = "years_Old")
    private int yearsOld;

    @Column(name = "Insurance")
    private String Insurance;

    @Column(name = "status")
    private String status;

    @Column(name = "image_Url")
    private String imageUrl;

    @Id
    @Column(name = "vendor_Id")
    private  Integer vendorId;

}

