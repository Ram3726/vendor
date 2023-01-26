package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.LoginTable;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginTable, Integer> {
}
