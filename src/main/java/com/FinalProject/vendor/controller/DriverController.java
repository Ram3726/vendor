package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.DeleteCar;
import com.FinalProject.vendor.model.DeleteDriver;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverController")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/saveDriver")
    public String saveDriver(@RequestBody DriverModel driverModel){
       String msg =this.driverService.saveDriverInfo(driverModel);
        return  msg;
    }

    @GetMapping("/driverDetails")
    public List<DriverModel>  findDriver(@RequestParam String email){

        List<DriverModel> driverModels = this.driverService.findDriverInfo(email);

        return driverModels;
    }



   /* @DeleteMapping("/delete")
    public String delete(@RequestParam String license){

        String msg = this.driverService.delete(license);

        return msg;

    }*/




    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteDriver deleteDriver){

        String driverInformation = this.driverService.deleteAll(deleteDriver.getDriverLicenseToBeDeleted());

        return driverInformation;

    }


}
