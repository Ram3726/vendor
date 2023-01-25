package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/carController")
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping("/save")
    public String saveCar(@RequestBody CarInformation carInformation) {
        this.carService.saveCar(carInformation);


        return "success";
    }


    @GetMapping("/carsDetails")

    public List<CarInformation> finData(@RequestParam String carType) {
        List<CarInformation> carInformation = this.carService.fetchRecords(carType);

        return carInformation;
    }

    @GetMapping("/carsById")

    public CarInformation findById(@RequestParam Integer id) {
        CarInformation carInformation = this.carService.records(id);

        return carInformation;
    }

    @DeleteMapping("delete-car/{carType}")
    public String deleteCar(@PathVariable String carType) {
        carService.delete(carType);
        return carType;
    }





    }

