package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import com.FinalProject.vendor.entity.DriverTable;
import com.FinalProject.vendor.entity.VendorRegistrationTable;
import com.FinalProject.vendor.model.DriverModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverTable, Integer> {

    //List<DriverTable> findByVendorId(Integer vendorId);// old



    @Query("Select id from DriverTable where vendorId=:vId AND driverLicenceNumber in (:driverLicense)")//for DELETE
    List<Integer> findByVendorIdAndDriverLicenceNumberIn(Integer vId, List<String> driverLicense);
    @Transactional// Spring transactional required at DML query
    @Modifying
    void deleteAllByIdIn(List<Integer> id); // for DELETE

    List<DriverTable> findAllByIdIn(List<Integer> id);// Using above also for GET

}
