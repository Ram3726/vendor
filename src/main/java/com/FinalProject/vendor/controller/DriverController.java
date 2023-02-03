package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.model.DeleteCar;
import com.FinalProject.vendor.model.DeleteDriver;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.DriverRepository;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverController")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/saveDriver")
    public String saveDriver(@RequestBody DriverModel driverModel){
       String msg =this.driverService.saveDriverInfo(driverModel);
        return  msg;
    }

    @GetMapping("/driverDetails")
    public void findDriver(@RequestParam String licence){

        this.driverService.findDriverInfo(licence);
    }

@PutMapping("/update")
public void update(@RequestBody DriverModel driverModel){

        this.driverService.updateDriverInfo(driverModel);
}



    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        this.driverRepository.deleteById(id);
        return "Driver deleted successfully";

    }


}
