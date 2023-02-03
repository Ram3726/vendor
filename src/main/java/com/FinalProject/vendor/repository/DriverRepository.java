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

    @Query("Select d from DriverTable d where d.vendorRegistrationTable.id =:vendorId")
    DriverTable findByVendorId(Integer vendorId);// for fetching records


    @Query("Select id from DriverTable where vendorId=:vId AND driverLicenceNumber in (:driverLicense)")
    List<Integer> findByVendorIdAndDriverLicenceNumberIn(Integer vId, List<String> driverLicense);
    @Transactional// Spring transactional required at DML query
    @Modifying
    void deleteAllByIdIn(List<Integer> id);

    DriverTable findByDriverLicenceNumber(String licence);
}
