package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public String  saveCar(CarInformation carInformation) {
        CarTable carTable = new CarTable();
        carTable.setCarType(carInformation.getCarType());
        carTable.setCarModel(carInformation.getCarModel());
        carTable.setCarSeater(carInformation.getCarSeater());
        carTable.setBaggageCapacity(carInformation.getBaggageCapacity());
        carTable.setCarRegistration(carInformation.getCarRegistration());
        carTable.setCarACorNonAc(carInformation.getCarACorNonAc());
        carTable.setBasePrice(carInformation.getBasePrice());
        carTable.setYearsOld(carInformation.getYearsOld());
        carTable.setInsurance(carInformation.getInsurance());
        carTable.setStatus(carInformation.getStatus());
        carTable.setImageUrl(carInformation.getImageUrl());


        try {
            carRepository.save(carTable);
        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }
        return "successful";
    }


}

