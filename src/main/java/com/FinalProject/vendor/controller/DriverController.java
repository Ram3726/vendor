package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/display")
    public String displayDriver(@RequestBody DriverModel driverModel){
        this.driverService.displayDriver(driverModel);
        return  "showdriver";
    }
}