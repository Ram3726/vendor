package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <AddressEntity,Integer> {
}
