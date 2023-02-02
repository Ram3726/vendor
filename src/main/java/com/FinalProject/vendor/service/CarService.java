package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.entity.LoginTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
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




// fetching car details
    public List <CarInformation> fetchCarRecords(String email) { // method to fetch records by using vendor email
        Integer vendorId = vendorRegRepository.findByVendorEmail("abc@test.com");
        List<CarTable> carTable = this.carRepository.findByVendorId(vendorId);// fetching data and storing in 'carTable' by passing vendorId parameter
        List <CarInformation> carInformation = new ArrayList<>();// Array list to store data
        if(carTable != null){ // checking if carTable is not null go for next step
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


// updating car details
    public String updateCar(List<CarInformation> carInformation) {// list of car information
        Integer vendorId = vendorRegRepository.findByVendorEmail("abc@test.com");//to find vendor id by using vendor email from vendor table to update in car table

        List<String> carRegistrationDetails = new ArrayList<>();// to store carRegistrationDetails and  list created

        for(CarInformation carInformation1 : carInformation){// advance loop to iterate car information
            carRegistrationDetails.add(carInformation1.getCarRegistration());// carRegistration added into List CarRegistrationDetails
            carRegistrationDetails.add(carInformation1.getStatus()); //status added into list CarRegistrationDetails
        }

        List<CarTable> carTable = this.carRepository.findByVendorIdAndCarRegistrationIn(vendorId,carRegistrationDetails);// car table list based on vendorId and CarRegistration

            for (CarInformation carInfo : carInformation) { //advance loop to iterate each element from model

                for( CarTable carTable1 : carTable) {// advance loop from car table to carTable1

                    carTable1.setBasePrice(carInfo.getBasePrice());// updating base price got from model
                    carTable1.setStatus(carInfo.getStatus());// updating status got from model

                    carRepository.save(carTable1);
                }

                }
            return "car Updated";
        }
 //Working on  Deleting car


        public String deleteAll(List <String> carRegistration){
            Integer vendorId = vendorRegRepository.findByVendorEmail("abc@test.com");

            try {
                carRepository.deleteAllByVendorIdAndCarRegistrationIn(vendorId, carRegistration);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }


            return " car Deleted";
        }




//save car details
    public String saveCar(List<CarInformation> carInformation)  { //method to save car
        Integer vendorId = vendorRegRepository.findByEmail("abc@test.com");//to find vendor id from email
        for (CarInformation carInfo : carInformation) {//advance loop to set each element from model
            CarTable carTable = new CarTable();

            if(carTypeValidation(carInfo.getCarType())){
                carTable.setCarType(carInfo.getCarType());
            }else{
                return "carType should not be null";
            }

            if(carModelValidation(carInfo.getCarModel())){
                carTable.setCarModel(carInfo.getCarModel());

            }else{
                return "carModel should not be null";
            }

            if(carRegistrationValidation(carInfo.getCarRegistration())){
                carTable.setCarRegistration(carInfo.getCarRegistration());

            }else{
                return "‘Car registration number is incorrect";
            }

            if(carInsuranceValidation(carInfo.getInsurance())){
                carTable.setInsurance(carInfo.getInsurance());

            }else{
                return "Car insurance can't be null or empty";
            }

            carTable.setCarSeater(carInfo.getCarSeater());
            carTable.setBaggageCapacity(carInfo.getBaggageCapacity());
            carTable.setCarACorNonAc(carInfo.getCarACorNonAc());
            carTable.setBasePrice(carInfo.getBasePrice());
            carTable.setYearsOld(carInfo.getYearsOld());
            carTable.setStatus(carInfo.getStatus());
            carTable.setImageUrl(carInfo.getImageUrl());
            carTable.setVendorId(vendorId);// saving vendor id in car table




            try {
                carRepository.save(carTable);
            } catch (Exception e) {
                System.err.println("Error details " + e.getMessage());
            }
        }
        return "Saved in Data base";
    }

    public boolean carTypeValidation( String carType){
        if(!carType.isEmpty() && carType != null){
            return true;
        }
        return false;
    }

    public boolean carModelValidation( String carModel){
        if(!carModel.isEmpty() && carModel != null){
            return true;
        }
        return false;
    }

    public boolean carRegistrationValidation(String carRegistration) {
        if (!carRegistration.isEmpty() && carRegistration != null && carRegistration.length() == 8
                && Character.isAlphabetic(carRegistration.charAt(0)) && Character.isAlphabetic(carRegistration.charAt(1))){
            return true;
    }
    return false;
    }

    public boolean carInsuranceValidation(String carInsurance){
        if(!carInsurance.isEmpty() && carInsurance != null){
            return true;
        }

        return false;

    }



}
