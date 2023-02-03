package com.FinalProject.vendor.service;


import com.FinalProject.vendor.entity.VendorLoginTable;
import com.FinalProject.vendor.entity.VendorRolesTable;
import com.FinalProject.vendor.repository.VendorRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VendorUserDetails implements UserDetails {
    private VendorLoginTable vendorLoginTable;


    private VendorRoleRepository vendorRoleRepository;


    public VendorUserDetails(VendorLoginTable vendorLoginTable, VendorRoleRepository vendorRoleRepository) {
        this.vendorLoginTable = vendorLoginTable;
    this.vendorRoleRepository = vendorRoleRepository;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<VendorRolesTable> vendorRolesTableList = null;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        try{
            vendorRolesTableList = this.vendorRoleRepository.findByVendorLoginTable(this.vendorLoginTable);
            for(VendorRolesTable roles : vendorRolesTableList){
                authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
            }
        }catch (Exception e)
        {
           e.getMessage();
        }


        return authorities;
    }
    @Override
    public String getPassword(){
        return this.vendorLoginTable.getPassword();
    }
    @Override
    public String getUsername(){
        return this.vendorLoginTable.getEmail();
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;

    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;

    }
}


