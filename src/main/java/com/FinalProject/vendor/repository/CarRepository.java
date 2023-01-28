package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<CarTable,Integer> {
    @Query("SELECT a FROM CarTable a where a.carType =:carType") //'a' is an alias of CarTable;
    List<CarTable> findByCarType(String carType);

    Optional<CarTable> findbyId(Integer id);

}





