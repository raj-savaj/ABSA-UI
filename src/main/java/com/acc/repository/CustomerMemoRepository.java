package com.acc.repository;

import com.acc.entity.CustomerMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerMemoRepository extends JpaRepository<CustomerMemo, String> {
    @Query("SELECT c.memoNumber FROM CustomerMemo c WHERE c.customerId = :custId AND c.status = 'A'")
    List<Long> findMemoNumbersByCustomerId(@Param("custId") Long customerId);
}
