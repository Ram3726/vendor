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

import javax.persistence.Id;

@Service
public class VendorService {

    @Autowired
    VendorRegRepository vendorRegRepository;
    @Autowired
    LoginRepository loginRepository; // adding login repository into the vendor service


    public String save;

    public String saveVendor(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = new VendorRegistrationTable();
        LoginTable loginTable = new LoginTable(); // object of login table
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
        //getting login email and password from login to vendor reg. table
        loginTable.setLoginEmail(vendorRegModel.getEmail());
        loginTable.setLoginPassword(vendorRegModel.getPassword());
        loginTable.setVendorRegistrationTable(vendorRegistrationTable); // setting login table to vendorReg table.


        try {
        //    vendorRegRepository.save(vendorRegistrationTable);
            loginRepository.save(loginTable);
        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }

        return "successful";
    }

    public VendorRegModel fetchRecords(String email) {
        VendorRegistrationTable vendorRegistrationTable = this.vendorRegRepository.findByEmailId(email);
        VendorRegModel vendorRegModel = new VendorRegModel();
        if (vendorRegistrationTable != null) {
            vendorRegModel.setEmail(vendorRegistrationTable.getEmail());
            vendorRegModel.setFirstName(vendorRegistrationTable.getFirstName());
            vendorRegModel.setLastName(vendorRegistrationTable.getLastName());
            vendorRegModel.setAddress(vendorRegistrationTable.getAddress());
            vendorRegModel.setPhoneNumber(vendorRegistrationTable.getPhoneNumber());
            vendorRegModel.setLicenseNumber(vendorRegistrationTable.getLicenseNumber());
            vendorRegModel.setBusinessRegistrationNo(vendorRegistrationTable.getBusinessRegistrationNo());
            vendorRegModel.setStatus(vendorRegistrationTable.getStatus());

        }
        return vendorRegModel;


    }

   /*public  UpdateEmail(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = this.vendorRegRepository.findByEmail(String email);
        VendorRegModel vendorRegModel = new VendorRegModel();

        return "email updated successfully";
*/
 //   }
}
