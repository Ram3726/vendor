package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.DriverAddressTable;
import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.model.DriverAddress;
import com.FinalProject.vendor.model.DriverModel;
import com.FinalProject.vendor.repository.AddressRepository;
import com.FinalProject.vendor.repository.DriverRepository;
import com.FinalProject.vendor.repository.VendorRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private VendorRegRepository vendorRegRepository;

    public String display;

    public String saveDriverInfo(DriverModel driverModel) {

        Integer vendorId = vendorRegRepository.findByEmail("abc@test.com");//to find vendor id from email

        DriverTable driverTable = new DriverTable();
        driverTable.setDriverId(driverModel.getDriverId());
        driverTable.setName(driverModel.getName());
        driverTable.setPhone(driverModel.getPhone());
        driverTable.setPhoto(driverModel.getPhoto());
        driverTable.setDriverLicenceNumber(driverModel.getDriverLicenceNumber());
        driverTable.setVendorId(vendorId);//getting VendorId from top variable

        //To get address from driver model
        DriverAddress driverAddressList = driverModel.getDriverAddress();


        DriverAddressTable driverAddressTable = new DriverAddressTable();
        driverAddressTable.setCity(driverAddressList.getCity());
        driverAddressTable.setCountry(driverAddressList.getCountry());
        driverAddressTable.setPin(driverAddressList.getPin());

        driverTable.setDriverAddressTable(driverAddressTable);

        try {
            addressRepository.save(driverAddressTable);
            driverRepository.save(driverTable);
        } catch (Exception e) {
            System.err.println("Error details " + e.getMessage());
        }
        // }
        return "successful";

    }



    public String updateDriver(DriverModel driverModel) {
        Integer vendorId= vendorRegRepository.findByVendorEmail("abc@test.com");
        DriverTable driverTable = this.driverRepository.findByVendorId(vendorId);
        driverTable.setDriverLicenceNumber(driverModel.getDriverLicenceNumber());
        driverTable.setName(driverModel.getName());

        driverRepository.save(driverTable);


    return "updated";
    }

    public String deleteDriverId(DriverModel driverModel){

        DriverTable driverTable = driverRepository.findByDriverId(driverModel.getDriverId());
        driverRepository.delete(driverTable);

        return "Deleted";
    }


}

