package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.CarInformation;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;




@RequestMapping("/register")
public class DriverController {

    @Autowired
    private DriverService driverService;
    @PostMapping("/save")

    public String save(@RequestBody List<DriverModel> driverModel) {
        this.driverService.saveDriver(driverModel);
        return "Success!!!";
    }
}
