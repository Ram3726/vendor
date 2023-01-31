package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.VendorLoginTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.entity.VendorRolesTable;
import com.FinalProject.vendor.model.VendorRegModel;
import com.FinalProject.vendor.model.VendorRoles;
import com.FinalProject.vendor.repository.LoginRepository;
import com.FinalProject.vendor.repository.VendorRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    VendorRegRepository vendorRegRepository;
    @Autowired
    LoginRepository loginRepository; // adding login repository into the vendor service


    public String save;

    public String saveVendor(VendorRegModel vendorRegModel) {
        VendorRegistrationTable vendorRegistrationTable = new VendorRegistrationTable();
        VendorLoginTable vendorLoginTable = new VendorLoginTable(); // object of login table
        vendorLoginTable.setLoginPassword(vendorRegistrationTable.getPassword());
        vendorLoginTable.setLoginEmail(vendorRegistrationTable.getEmail());



            List<VendorRoles> vendorRolesList = vendorRegModel.getRole();
        for(VendorRoles vendorRole:vendorRegModel.getRole()){
            VendorRolesTable vendorRolesTable = new VendorRolesTable(); // object of vendor roles table
           vendorRolesTable.setRoleName(vendorRole.getRoleName());
           vendorRolesTable.setVendorLoginTable(vendorRolesTable.getVendorLoginTable());
           vendorRolesTable.setVendorLoginTable(vendorLoginTable);
           vendorRolesTable.add(vendorRolesTable);
           //loginRepository.save(vendorRegistrationTable);
        }




        vendorRegistrationTable.setAddress(vendorRegModel.getAddress());
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
            vendorRegistrationTable.setPassword(vendorRegModel.getPassword());
            vendorRegistrationTable.setConfirmPassword(vendorRegModel.getConfirmPassword());

        }else{
            return "Password is not valid!!";
        }

       // vendorRegistrationTable.setOperatingCity(vendorRegModel.getOperatingCity());
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

        vendorRegistrationTable.setVendorLoginTable(vendorLoginTable);




        try {
           vendorRegRepository.save(vendorRegistrationTable);
            //loginRepository.save(loginTable);
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
    * */

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

    public VendorRegModel updateEmailId(String email) {
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

}
