package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarTable,Integer> {
}
