package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorLoginTable;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<VendorLoginTable, Integer> {
    VendorLoginTable findByEmail(String emailAddress);

}
