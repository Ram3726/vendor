package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarRegistrationPkId;
import com.FinalProject.vendor.entity.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRepository extends CrudRepository<CarTable, Integer> {
    List<CarTable> findByVendorId(Integer vendorId);// for fetching records

    List<CarTable> findByVendorIdAndCarRegistrationIn(Integer vendorId, List<String> carRegistration);// for fetching records


    @Transactional// Spring transactional required at DML query
    @Modifying// required for DML query
    @Query("Delete from CarTable where vendorId=:vId AND carRegistration in (:carRegistrationIds)")
    void deleteAllByVendorIdAndCarRegistrationIn(Integer vId,List<String> carRegistrationIds);








}
