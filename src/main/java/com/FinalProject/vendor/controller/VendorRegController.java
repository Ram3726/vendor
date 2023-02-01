package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.model.VendorRoles;
import com.FinalProject.vendor.repository.VendorRegRepository;
import com.FinalProject.vendor.repository.VendorRoleRepository;
import com.FinalProject.vendor.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/vendorRegistration")
public class VendorRegController {
    @Autowired
    private VendorService vendorService;
    @Autowired
    private VendorRegRepository vendorRegRepository;



    @PostMapping("/save") // SAVING
    public String save(@RequestBody VendorRegModel vendorRegModel) {
         this.vendorService.saveVendor(vendorRegModel);
        return "Vendor Reg Success";
    }

    @GetMapping("/fetch")  // Fetching
    public VendorRegistrationTable fetchData(@RequestParam String email) {

        return this.vendorRegRepository.findByVendorEmail(email);
    }

    @PutMapping("/update")  // Updating
    public String updateVendorDetail(@RequestBody VendorRegModel vendorRegModel) {
        this.vendorService.updateVendorDetail(updateVendorDetail(vendorRegModel));

        return "VendorUpdated ";

    }

    @DeleteMapping("/delete")  // Deleting
    public String deleteVendorInfo(@RequestParam Integer vendID) {
        this.vendorService.deleteVendorInfo(vendID);
        return "delete Successful !!";
    }

}




