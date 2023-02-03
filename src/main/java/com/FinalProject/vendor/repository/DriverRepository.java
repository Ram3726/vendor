package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverTable, Integer> {

    List<DriverTable> findByVendorId(Integer vendorId);// for fetching records

    @Transactional// Spring transactional required at DML query
    @Modifying// required for DML query
    @Query("Delete from DriverTable where vendorId=:vId AND driverLicenceNumber in (:driverLicense)")
    void deleteAllByVendorIdAndDriverLicenceNumberIn(Integer vId, List<String> driverLicense);
}
