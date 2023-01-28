package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/updateDriver")
    public String updateDriver(@RequestBody DriverModel driverModel) {

        this.driverService.updateDriverDetails(driverModel);
        return "Customer Detail is updated";
    }

    @GetMapping("/fecthCustomer")
    public DriverModel fetchDriver(@RequestBody DriverModel driverModel) {

        DriverModel customerModel1 = this.driverService.fetchDriverDetails(driverModel);
        return customerModel1;
    }

    @DeleteMapping("/deleteDriverRecord")
    public String deleteDriverRecord(@RequestParam Integer drvId) {
        this.driverService.deleteDriverInfo(drvId);

        return "delete Successful!!";
    }

}
