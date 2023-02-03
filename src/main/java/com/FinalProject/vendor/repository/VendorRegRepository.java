package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VendorRegRepository extends CrudRepository<VendorRegistrationTable , Integer> {

    @Query("Select p.id from VendorRegistrationTable p where p.email=:email")
    Integer findByEmail(String email);
    @Query("Select v from VendorRegistrationTable v where v.email=:email")
    VendorRegistrationTable findByVendorEmail(String email);
}
