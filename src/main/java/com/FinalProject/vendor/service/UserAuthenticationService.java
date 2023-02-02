package com.FinalProject.vendor.service;

import com.FinalProject.vendor.entity.VendorLoginTable;
import com.FinalProject.vendor.repository.LoginRepository;
import com.FinalProject.vendor.repository.VendorRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserAuthenticationService implements UserDetailsService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    VendorRoleRepository vendorRoleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        VendorLoginTable vendorLoginTable = this.loginRepository.findByEmail(username); //username is email for Vendor
        VendorUserDetails vendorUserDetails = new VendorUserDetails(vendorLoginTable,vendorRoleRepository);
        return vendorUserDetails;


    }
}

