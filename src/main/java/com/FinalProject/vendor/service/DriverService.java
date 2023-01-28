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
DriverRepository driverRepository;

    public String saveDriver(List<DriverModel> driverModels)  {
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
}















