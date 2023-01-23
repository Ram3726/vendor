package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<DriverTable, Integer> {

}