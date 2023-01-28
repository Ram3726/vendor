package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.repository.VendorRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    VendorRegRepository vendorRegRepository;

    public String save;

    public String saveVendor(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = new VendorRegistrationTable();
        vendorRegistrationTable.setFirstName(vendorRegModel.getFirstName());
        vendorRegistrationTable.setLastName(vendorRegModel.getLastName());
        //vendorRegistrationTable.setCompanyName(vendorRegModel.getCompanyName());
        vendorRegistrationTable.setAddress(vendorRegModel.getAddress());
        vendorRegistrationTable.setEmail(vendorRegModel.getEmail());
        vendorRegistrationTable.setPhoneNumber(vendorRegModel.getPhoneNumber());
        vendorRegistrationTable.setPassword(vendorRegModel.getPassword());
        vendorRegistrationTable.setConfirmPassword(vendorRegModel.getConfirmPassword());
        // vendorRegistrationTable.setOperatingCity(vendorRegModel.getOperatingCity());
        vendorRegistrationTable.setLicenseNumber(vendorRegModel.getLicenseNumber());
        vendorRegistrationTable.setBusinessRegistrationNo(vendorRegModel.getBusinessRegistrationNo());
        vendorRegistrationTable.setStatus(vendorRegModel.getStatus());

        try {
            vendorRegRepository.save(vendorRegistrationTable);
        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }

        return "successful";

    }



}