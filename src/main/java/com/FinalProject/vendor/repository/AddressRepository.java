package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.DriverAddressTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<DriverAddressTable, Integer> {

}
