
package com.FinalProject.vendor.repository;

import com.FinalProject.vendor.entity.VendorLoginTable;
import com.FinalProject.vendor.entity.VendorRolesTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VendorRoleRepository extends JpaRepository<VendorRolesTable, Integer> {
    List<VendorRolesTable>findByVendorLoginTable(VendorLoginTable vendorLoginTable);

   @Transactional
   @Modifying

    @Query("Delete from VendorRolesTable where vendorLoginTable.id =:vendId")
    void deleteByVendorID(Integer vendId);

}
