package com.FinalProject.vendor.controller;

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


    @GetMapping("/driverDetails")  //new (fetching by driver license)
    public List<DriverModel> findDriver(@RequestBody List<DriverModel> driverLicense){
        List<DriverModel> driverModels = this.driverService.findDriver(driverLicense);
        return driverModels;

        }


        @PutMapping("/update")
        public String update(@RequestBody List<DriverModel> driverModels){

        String updateMsg = this.driverService.updateDriver(driverModels);


        return updateMsg;
        }




    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteDriver deleteDriver){

        String driverInformation = this.driverService.deleteAll(deleteDriver.getDriverLicenseToBeDeleted());

        return driverInformation;

    }


}
