package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VendorRegRepository extends CrudRepository<VendorRegistrationTable , Integer>{
    @Query("Select id from VendorRegistrationTable  where email = :email")// to fetch vendor id and save into carTable
    Integer findByEmail(String email); // find vendor id to save in car table
    @Query("Select id from VendorRegistrationTable  where email = :email")// using email to find vendor id to fetch all cars
    Integer findByVendorEmail(String email);// get vendor id to etch car





}
