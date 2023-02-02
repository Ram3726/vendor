package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.DriverRepository;
import com.FinalProject.vendor.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driverController")
public class DriverController {
    @Autowired
    private DriverService driverService;
    
    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/saveDriver")
    public String saveDriver(@RequestBody DriverModel driverModel) {
        this.driverService.saveDriverInfo(driverModel);
        return "Driver Details Saved";
    }

   @PutMapping("/Update")
    public String update(@RequestBody DriverModel driverModel) {
        String updateInformation = this.driverService.updateDriver(driverModel);
        return updateInformation;
    }

    @DeleteMapping("/delete")
public String delete(@RequestParam Integer driverId){
        this.driverRepository.deleteBydriverId(driverId);

    return "Delete sucessfully";

}
}











