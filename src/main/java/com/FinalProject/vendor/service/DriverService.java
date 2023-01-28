package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.AddressEntity;
import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.model.Address;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;


    public String saveDriver(List<DriverModel> driverModels) {
        // Integer vendorId = vendorRegRepository.findByEmail("abc@test.com");
        for (DriverModel driverdetails : driverModels) {//advance loop to set each element from model
            DriverTable driverTable = new DriverTable();
            driverTable.setDriverId(driverdetails.getDriverId());
            driverTable.setDriverName(driverdetails.getDriverName());
            driverTable.setPhoneNo(driverdetails.getPhoneNo());
            driverTable.setDrivingLicense(driverdetails.getDrivingLicense());


            List<Address> addresses = driverdetails.getAddresses();
            for (Address address : addresses) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setCity(address.getCity());
                addressEntity.setCountry(address.getCountry());
                addressEntity.setPin(address.getPin());
                driverTable.getAddresses().add(addressEntity);
            }

            try {
                driverRepository.save(driverTable);
            } catch (Exception e) {
                System.err.println("Error details " + e.getMessage());
            }
        }
        return "success";
    }

    // Update Logic
    public String updateDriverDetails(DriverModel driverModel
    ) {

        DriverTable driverTable = driverRepository.findBylicense(driverModel.getDrivingLicense());

        if (driverTable == null) {
            return "Error: driver not found.";
        }
        driverTable.setDriverId(driverModel.getDriverId());
        driverTable.setDriverName(driverModel.getDriverName());
        driverTable.setPhoneNo(driverModel.getPhoneNo());
        driverTable.setDrivingLicense(driverModel.getDrivingLicense());

        return "Driver details updated";
    }

    // Fetch Login
    public DriverModel fetchDriverDetails(DriverModel drivertable) {
        DriverTable driverTable = driverRepository.findBylicense(drivertable.getDrivingLicense());
        DriverModel driverModel1 = new DriverModel();

        if (driverTable != null) {

            driverModel1.setDriverId(drivertable.getDriverId());
            driverModel1.setDriverName(drivertable.getDriverName());
            driverModel1.setPhoneNo(drivertable.getPhoneNo());
            driverModel1.setDrivingLicense(drivertable.getDrivingLicense());

        }
        return driverModel1;
    }

    public String deleteDriverInfo(Integer id) {
        try {
            driverRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "Success";
    }
}















