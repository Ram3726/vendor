package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/carController")
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping("/save")

    public String save(@RequestBody List<CarInformation> carInformation) {
       String outputMessage = this.carService.saveCar(carInformation);
        return outputMessage;
    }


    @GetMapping("/carsDetailsByEmail") //fetch by vendor email

    public List<CarInformation> finData(@RequestParam String email){// vendor email needed as parameter
        List <CarInformation> carInformation = this.carService.fetchCarRecords(email);

        return carInformation;
    }


    @PutMapping("/update")//update records in car Table
    public String update(@RequestBody List<CarInformation> carInformation) {// list of car information
        String updateMessage = this.carService.updateCar(carInformation);//updateCar method created for update
        return updateMessage;
    }

    @DeleteMapping("/delete")
    public List<CarInformation> delete(@PathVariable String email){

        List<CarInformation> carInformation = this.carService.deleteCar(email);

        return carInformation;

    }








}
