package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VendorRegRepository extends CrudRepository<VendorRegistrationTable , Integer>{
    @Query("Select id from VendorRegistrationTable where email = :email")
    Integer findByEmail(String email);


}