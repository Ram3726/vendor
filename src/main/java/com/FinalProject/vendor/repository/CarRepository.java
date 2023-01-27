package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<CarTable,Integer> {
    List<CarTable> findByCarType(String carType);

    static Optional<CarTable> findById(Integer integer);
}
