package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.DriverTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface DriverRepository extends JpaRepository<DriverTable, Integer> {
    DriverTable  findByVendorId (Integer vendorId);

    DriverTable findByDriverId(String driverId);

    @Transactional// Spring transactional required at DML query
    @Modifying// required for DML query
    @Query("Delete from DriverTable where DriverTable.id= :driverId")
    void deleteBydriverId(Integer driverId);



}
