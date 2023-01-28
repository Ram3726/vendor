package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.DriverTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverTable, Integer> {




}