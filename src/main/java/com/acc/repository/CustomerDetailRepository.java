package com.acc.repository;

import com.acc.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, String> {

    Optional<CustomerDetail> findByCustomerIdAndMaintenanceFlag(Integer customerId, String mntFlag);

}
