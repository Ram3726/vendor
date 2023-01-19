package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendorRegController")
public class VendorRegController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/save")
    public String saveVendor(@RequestBody VendorRegModel vendorRegModel){
        this.vendorService.saveVendor(vendorRegModel);

        return  "ShowVendor";
    }

    public String setFirstName(String firstName) {
        return firstName;
    }
}
