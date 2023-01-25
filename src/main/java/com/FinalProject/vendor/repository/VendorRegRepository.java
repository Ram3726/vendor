package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VendorRegRepository extends CrudRepository<VendorRegistrationTable , Integer>{
    @Query("Select p from VendorRegistrationTable p where p.email = :email")
    Integer findByEmail(String email);


}
