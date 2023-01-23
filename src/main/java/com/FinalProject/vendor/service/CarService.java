package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.repository.CarRepository;
import com.FinalProject.vendor.repository.VendorRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    VendorRegRepository vendorRegRepository;



    public List <CarInformation> fetchRecords(Integer vendorId) { // method to fetch records
        List<CarTable> carTable = this.carRepository.findByVendorId(vendorId);// fetching data and storing in 'carTable' by passing vendorId parameter
        List <CarInformation> carInformation = new ArrayList<>();// Array list to store data
        if(carTable != null){// checking if carTable is not null go for next step
            for( CarTable cars: carTable) {// for each loop to iterate. 'carTable' data pass to cars.
                CarInformation carInformation1 = new CarInformation();// creating new object to store data.
                carInformation1.setCarModel(cars.getCarModel());// iterating and setting data from cars(carTable) to carInformation1 (temporary)
                carInformation1.setCarACorNonAc(cars.getCarACorNonAc()); //iterating and setting data from cars(carTable) to carInformation1 (temporary)
                carInformation1.setCarSeater(cars.getCarSeater());
                carInformation1.setCarType(cars.getCarType());
                carInformation1.setCarRegistration(cars.getCarRegistration());
                carInformation1.setStatus(cars.getStatus());
                carInformation1.setBaggageCapacity(cars.getBaggageCapacity());
                carInformation1.setBasePrice(cars.getBasePrice());
                carInformation1.setImageUrl(cars.getImageUrl());
                carInformation1.setInsurance(cars.getInsurance());
                carInformation1.setYearsOld(cars.getYearsOld());
                carInformation.add(carInformation1);
            }

        }
        return carInformation;
    }


    public String saveCar(List<CarInformation> carInformation)  {
        Integer vendorId = vendorRegRepository.findByEmail("abc@test.com");
        for (CarInformation carInfo : carInformation) {//advance loop to set each element from model
            CarTable carTable = new CarTable();
            carTable.setCarType(carInfo.getCarType());
            carTable.setCarModel(carInfo.getCarModel());
            carTable.setCarSeater(carInfo.getCarSeater());
            carTable.setBaggageCapacity(carInfo.getBaggageCapacity());
            carTable.setCarRegistration(carInfo.getCarRegistration());
            carTable.setCarACorNonAc(carInfo.getCarACorNonAc());
            carTable.setBasePrice(carInfo.getBasePrice());
            carTable.setYearsOld(carInfo.getYearsOld());
            carTable.setInsurance(carInfo.getInsurance());
            carTable.setStatus(carInfo.getStatus());
            carTable.setImageUrl(carInfo.getImageUrl());
            carTable.setVendorId(vendorId);

            try {
                carRepository.save(carTable);
            } catch (Exception e) {
                System.err.println("Error details " + e.getMessage());
            }
        }
        return "success";
    }


}