package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public String saveCar(CarInformation carInformation) {
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
     carTable.setMinKmDriven(carInformation.getMinKmDriven());


        try {
            carRepository.save(carTable);
        } catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }
        return "successful";
    }


    public List <CarInformation> fetchRecords(String carType) {
       List<CarTable> carTable = this.carRepository.findByCarType(carType);
       List <CarInformation> carInformation = new ArrayList<>();
        if(carTable != null){
            for( CarTable cars: carTable) {
                CarInformation carInformation1 = new CarInformation();
                carInformation1.setCarModel(cars.getCarModel());
                carInformation1.setCarACorNonAc(cars.getCarACorNonAc());
                carInformation.add(carInformation1);
            }

        return carInformation;
    }

    public CarInformation records(Integer id) {
        Optional<CarTable> carTable = carRepository.findById(id);
        CarInformation carInformation = new CarInformation();
        if(carTable.isPresent()){
            CarTable carTable1 = carTable.get();

                carInformation.setCarModel(carTable1.getCarModel());
                carInformation.setCarACorNonAc(carTable1.getCarACorNonAc());
            }


        return carInformation;
    }

    public String updateDetail(Integer id, CarInformation carInformation) {
        CarTable carTable = carRepository.findById(id).get();
        carTable.setMinKmDriven((carInformation.getMinKmDriven()));
        carTable.setStatus((carInformation.getStatus()));
        carTable.setBasePrice(carInformation.getBasePrice());
        carRepository.save(carTable);

        return "update";
    }
}
