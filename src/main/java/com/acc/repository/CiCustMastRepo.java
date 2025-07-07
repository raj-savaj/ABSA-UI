package com.acc.repository;

import com.acc.entity.CiCustMast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CiCustMastRepo extends JpaRepository<CiCustMast, String> {
    // Search by ID
    @Query("SELECT c FROM CiCustMast c WHERE c.customerId = :id AND c.status = 'A'")
    List<CiCustMast>  findCustomerById(@Param("id") Long id);

    // Search by Short Name (case-insensitive)
    @Query("SELECT c FROM CiCustMast c WHERE LOWER(c.shortName) LIKE LOWER(CONCAT('%', :shortName, '%')) AND c.status = 'A'")
    List<CiCustMast> findCustomersByShortName(@Param("shortName") String shortName);

    // Search by IC (National ID)
    @Query("SELECT c FROM CiCustMast c WHERE c.nationalId = :ic AND c.status = 'A'")
    List<CiCustMast>  findCustomerByNationalId(@Param("ic") String nationalId);
}
