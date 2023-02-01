package com.FinalProject.vendor.service;

import com.FinalProject.vendor.controller.VendorRegController;
import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.entity.LoginTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.repository.LoginRepository;
import com.FinalProject.vendor.repository.VendorRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    VendorRegRepository vendorRegRepository;

    @Autowired
    LoginRepository loginRepository;
    public String save;

    public String saveVendor(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = new VendorRegistrationTable();
        LoginTable loginTable = new LoginTable();
        vendorRegistrationTable.setFirstName(vendorRegModel.getFirstName());
        vendorRegistrationTable.setLastName(vendorRegModel.getLastName());
        vendorRegistrationTable.setEmail(vendorRegModel.getEmail());
        vendorRegistrationTable.setPhoneNumber(vendorRegModel.getPhoneNumber());
        vendorRegistrationTable.setPassword(vendorRegModel.getPassword());
        vendorRegistrationTable.setConfirmPassword(vendorRegModel.getConfirmPassword());
        vendorRegistrationTable.setLicenseNumber(vendorRegModel.getLicenseNumber());
        vendorRegistrationTable.setBusinessRegistrationNo(vendorRegModel.getBusinessRegistrationNo());
        vendorRegistrationTable.setStatus(vendorRegModel.getStatus());

        loginTable.setLoginPassword(vendorRegistrationTable.getPassword());
        loginTable.setLoginEmail(vendorRegistrationTable.getEmail());

        //loginTable.setVendorRegistrationTable(vendorRegistrationTable);

        vendorRegistrationTable.setLoginTable(loginTable);
        try {
            vendorRegRepository.save(vendorRegistrationTable);
           // loginRepository.save(loginTable);

        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }

        return "successful";
    }

}
