package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<CarTable,Integer> {
    List<CarTable> findByVendorId(Integer vendorId);






}
