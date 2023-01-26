package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    public String display;
    public String displayDriver(DriverModel driverModel) {
        DriverTable driverTable = new DriverTable();
        driverTable.setDriver_id(driverModel.getDriver_id());
        driverTable.setName(driverModel.getName());
        driverTable.setPhone(driverModel.getPhone());
        driverTable.setAddress(driverModel.getAddress());
        driverTable.setDriver_licence_number(driverModel.getDriver_licence_number());
        driverTable.setPhoto(driverModel.getPhoto());

        try {
            driverRepository.save(driverTable);
        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());
        }
        return "successful";

    }
}
