package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.VendorLoginTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.entity.VendorRolesTable;
import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.model.VendorRoles;
import com.FinalProject.vendor.repository.LoginRepository;
import com.FinalProject.vendor.repository.VendorRegRepository;
import com.FinalProject.vendor.repository.VendorRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    VendorRegRepository vendorRegRepository;
    @Autowired
    LoginRepository loginRepository; // adding login repository into the vendor service
    @Autowired
    VendorRoleRepository vendorRoleRepository; // adding role Repository into the vendor service



    public String saveVendor(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = new VendorRegistrationTable();
        VendorLoginTable vendorLoginTable = new VendorLoginTable(); // object of login table
        vendorLoginTable.setEmail(vendorRegModel.getEmail());
        vendorLoginTable.setLoginType(vendorRegModel.getLoginType());
        vendorRegistrationTable.setVendorLoginTable(vendorLoginTable);

        String encryptedPwd = "";
        encryptedPwd = this.bCryptPasswordEncoder.encode(vendorRegModel.getPassword());
        vendorLoginTable.setPassword(encryptedPwd);

        vendorRegistrationTable.setAddress(vendorRegModel.getAddress());

        vendorRegistrationTable.setFirstName(vendorRegModel.getFirstName());
        vendorRegistrationTable.setLastName(vendorRegModel.getLastName());

        vendorRegistrationTable.setLoginType(vendorRegModel.getLoginType());

        if(vendorEmailValidation(vendorRegModel.getEmail())){
            vendorRegistrationTable.setEmail(vendorRegModel.getEmail());
        }else{
            return "Email Address is not valid!!";
        }

        if(vendorPhoneNumberValidation(vendorRegModel.getPhoneNumber())) {
            vendorRegistrationTable.setPhoneNumber(vendorRegModel.getPhoneNumber());

        }else {
            return "Mobile number is incorrect!!";
        }

        if(vendorPasswordValidation(vendorRegModel.getPassword(),vendorRegModel.getConfirmPassword())){

            vendorRegistrationTable.setPassword(encryptedPwd);
            vendorRegistrationTable.setConfirmPassword(encryptedPwd);

        }else{
            return "Password is not valid!!";
        }

        if(licenseNumberValidation(vendorRegModel.getLicenseNumber())){
            vendorRegistrationTable.setLicenseNumber(vendorRegModel.getLicenseNumber());
        }else {
            return "Not a valid license!!";
        }

        if(businessRegistrationNoValidation(vendorRegModel.getBusinessRegistrationNo())){
            vendorRegistrationTable.setBusinessRegistrationNo(vendorRegModel.getBusinessRegistrationNo());

        }else {
            return "Not a valid business registration no.";
        }

        vendorRegistrationTable.setStatus(vendorRegModel.getStatus());

        try {
            //this.loginRepository.save(vendorLoginTable);
           this.vendorRegRepository.save(vendorRegistrationTable);
        }catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }
        List<VendorRoles> vendorRolesList = vendorRegModel.getRole();
        for(VendorRoles vendorRole: vendorRolesList){
            VendorRolesTable vendorRolesTable = new VendorRolesTable(); // object of vendor roles table
            vendorRolesTable.setRoleName(vendorRole.getRoleName());
            vendorRolesTable.setVendorLoginTable(vendorLoginTable);
            this.vendorRoleRepository.save(vendorRolesTable);

        }

        return "successful";
    }

        /*Login type should not be null if null then will not proceed, return with error
         message as 'Login Type cannot be null!!'
         */
        /*Email address should not be empty, and it should contain @. Otherwise return
            error message as 'Email Address is not valid!!'
            Email Validation
           */

    public boolean vendorEmailValidation(String vendorEmail){
        if(vendorEmail.contains("@")&& !vendorEmail.isEmpty()){
            return true;
        }
        return false;
    }

    /*
    * password and confirm password fields can’t be empty. If empty, Please return
        error message as 'Password can't be empty!!'
    * Password Validation
    */

    public boolean vendorPasswordValidation(String vendorPassword, String vendorConfirmPassword){

        if( !vendorPassword.isEmpty() && !vendorConfirmPassword.isEmpty() && vendorPassword.equals(vendorConfirmPassword)){
            return true;
        }
        return false;
    }
    public boolean vendorLoginTypeValidation(String loginType){
        if(!loginType.isEmpty()){
            return true;
        }

        return false;
    }
        /*
        * Mobile number should be of 10 digits.Otherwise return error message as
            'Mobile number is incorrect!!'
        * */
    public boolean vendorPhoneNumberValidation(String phoneNumber){
        if(phoneNumber.matches("\\d{10}")){
            return true;
        }

          return false;
    }
        /*
        * licenseNumber should start with "RTE" and should be of 10 characters. else
        return error message as 'Not a valid license!!'
        * */
    public boolean licenseNumberValidation(String licenseNumber){
        if(licenseNumber!= null && licenseNumber.length()==10 && licenseNumber.startsWith("RTE")){
            return true;
        }
        return false;
    }

        /*
        * businessRegistrationNo should be ending with "ERT". else return error message
        'Not a valid business registration no.'
         * */
    public boolean businessRegistrationNoValidation(String businessRegistrationNo){
        if(businessRegistrationNo!= null && businessRegistrationNo.endsWith("ERT")){
            return true;
        }
        return false;
    }

    public String updateVendorDetail(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = vendorRegRepository.findByVendorEmail(vendorRegModel.getEmail());
        String encryptedPwd = "";
        encryptedPwd = this.bCryptPasswordEncoder.encode(vendorRegModel.getPassword());
        System.out.println("Encrypted PWD: " + encryptedPwd);
        if (vendorRegistrationTable == null) {
            return "Error: Customer not found.";
        }
        vendorRegistrationTable.setLoginType(vendorRegModel.getLoginType());
        vendorRegistrationTable.setFirstName(vendorRegModel.getFirstName());
        vendorRegistrationTable.setLastName(vendorRegModel.getLastName());
        vendorRegistrationTable.setAddress(vendorRegModel.getAddress());

        if (vendorEmailValidation(vendorRegModel.getEmail())) {
            vendorRegistrationTable.setEmail(vendorRegModel.getEmail());
        } else {
            return "Email Address is not valid!!";
        }

        if (vendorPhoneNumberValidation(vendorRegModel.getPhoneNumber())) {
            vendorRegistrationTable.setPhoneNumber(vendorRegModel.getPhoneNumber());

        } else {
            return "Mobile number is incorrect!!";
        }

        if (vendorPasswordValidation(vendorRegModel.getPassword(), vendorRegModel.getConfirmPassword())) {

            vendorRegistrationTable.setPassword(encryptedPwd);
            vendorRegistrationTable.setConfirmPassword(encryptedPwd);

        } else {
            return "Password is not valid!!";
        }

        if (licenseNumberValidation(vendorRegModel.getLicenseNumber())) {
            vendorRegistrationTable.setLicenseNumber(vendorRegModel.getLicenseNumber());
        } else {
            return "Not a valid license!!";
        }

        if (businessRegistrationNoValidation(vendorRegModel.getBusinessRegistrationNo())) {
            vendorRegistrationTable.setBusinessRegistrationNo(vendorRegModel.getBusinessRegistrationNo());

        } else {
            return "Not a valid business registration no.";
        }
        vendorRegistrationTable.setStatus(vendorRegModel.getStatus());


        try {

            vendorRegRepository.save(vendorRegistrationTable);
        } catch (Exception e) {
            System.err.println("Error details " + e.getMessage());

        }
        return "Vendor details updated";
    }




}
