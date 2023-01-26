package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/carController")
public class CarController {
    @Autowired
    private CarService carService;







    @GetMapping("/carsDetails")

    public List<CarInformation> finData(@RequestParam Integer vendorId){// vendor email needed as parameter
        List <CarInformation> carInformation = this.carService.fetchRecords(vendorId);

        return carInformation;
    }

    @PostMapping("/save")

    public String save(@RequestBody List<CarInformation> carInformation) {
       String outputMessage = this.carService.saveCar(carInformation);
        return outputMessage;
    }





}
