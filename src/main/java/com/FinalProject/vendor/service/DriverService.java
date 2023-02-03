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
        if (licenseValidation(driverModel.getDriverLicenceNumber())) {
            driverTable.setDriverLicenceNumber(driverModel.getDriverLicenceNumber());
        } else {
            return "Invalid Driving license!";
        }

        driverTable.setVendorId(vendorId);//getting VendorId from top variable

        //To get address from driver model
        DriverAddress driverAddressList = driverModel.getDriverAddress();


        DriverAddressTable driverAddressTable = new DriverAddressTable();
        driverAddressTable.setCity(driverAddressList.getCity());
        driverAddressTable.setCountry(driverAddressList.getCountry());
        driverAddressTable.setPin(driverAddressList.getPin());

        driverTable.setDriverAddressTable(driverAddressTable);

        try {
            //addressRepository.save(driverAddressTable);
            driverRepository.save(driverTable);
        } catch (Exception e) {
            System.err.println("Error details " + e.getMessage());
        }
        // }
        return "Driver data save successful";

    }


    public boolean licenseValidation(String license) {
        if (license.length() == 8 && Character.isLetter(license.charAt(0)) && Character.isLetter(license.charAt(1))
                && Character.isDigit(license.charAt(license.length() - 2)) && Character.isAlphabetic(license.charAt(license.length() - 1))) {
            return true;
        }
        return false;
    }


    public List<DriverModel> findDriverInfo(String email) {
        Integer vendorId = this.vendorRegRepository.findByEmail("abc@test.com");
        List<DriverTable> driverTableList = this.driverRepository.findByVendorId(vendorId);//fetched list of drivers from table and stored inside driverTableList
        List<DriverModel> driverModelList = new ArrayList<>();// creating empty Model list to store all objects of driver

        if (driverModelList != null) {

            for (DriverTable driversTable : driverTableList) { //iterating and storing from driverTableList to driversTable

                DriverAddressTable driverAddressTable = driversTable.getDriverAddressTable();//getting address only from list

                DriverModel driverModel = new DriverModel();// creating object to store driver details from table

                DriverAddress driverAddress = new DriverAddress();
                driverModel.setName(driversTable.getName());
                driverModel.setDriverId(driversTable.getDriverId());
                driverModel.setPhone(driversTable.getPhone());
                driverModel.setPhoto(driversTable.getPhoto());
                driverModel.setDriverLicenceNumber(driversTable.getDriverLicenceNumber());
                driverAddress.setCountry(driverAddressTable.getCountry());
                driverAddress.setCity(driverAddressTable.getCity());
                driverAddress.setPin(driverAddressTable.getPin());

                driverModel.setDriverAddress(driverAddress);

                driverModelList.add(driverModel);
            }

        }
        return driverModelList;
    }





    public String deleteAll(List <String> driverLicense){
        Integer vendorId = vendorRegRepository.findByEmail("abc@test.com");

        try {
            List<Integer> id = driverRepository.findByVendorIdAndDriverLicenceNumberIn(vendorId, driverLicense);// finding list of driver id;

            driverRepository.deleteAllByIdIn(id);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        return " Driver Deleted";
    }





}











    //Where driver id will be the primary key and each driver object will be having vendor id present
//which will be derived from Vendor registration table. For each login we will be having the email
//address, corresponding to each email address we can find out the vendor id.
//Below validation must be satisfied,
//1. Driving license should be having 8 character and starts with 2 letter and end with a
//digit and a letter. If in case driving license is not present or invalid, show error
//message as ‘Invalid Driving license!’
//2. Mobile number should be 10 digit else will display error message as ‘Invalid mobile
//number presents!!’
//If above validation is successful, then save database to driver DB.
//• Write retrieve api to fetch the driver details from Database
//• Write update api to update driver information by vendor corresponding each saved
//vendor
//• Write Delete api to delete the driver information based on driver id and the vendor
//id.