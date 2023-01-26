package com.FinalProject.vendor.controller;

import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

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
    @GetMapping("/fetchSaveData")
    public  VendorRegModel fetchData(@RequestParam String email){
        VendorRegModel vendorRegModel = this.vendorService.fetchRecords(email);

        return vendorRegModel;
    }

   /* @PutMapping("/updateEmail")
    public  VendorRegModel updateEmail(@RequestBody VendorRegModel vendorRegModel) {
        this.vendorService.updateEmail(vendorRegModel);

        return vendorRegModel;

    }

*/
}
