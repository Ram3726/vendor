package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driverController")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/saveDriver")
    public String saveDriver(@RequestBody DriverModel driverModel){
       this.driverService.saveDriverInfo(driverModel);
        return  "Driver Details Saved";
    }
}
