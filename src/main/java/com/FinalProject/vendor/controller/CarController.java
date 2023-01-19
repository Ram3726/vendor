package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carController")
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping("/save")
    public String saveCar(@RequestBody CarInformation carInformation){
        this.carService.saveCar(carInformation);


        return "success";
    }





}
