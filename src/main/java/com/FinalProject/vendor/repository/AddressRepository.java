package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.DriverAddressTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<DriverAddressTable, Integer> {
}
