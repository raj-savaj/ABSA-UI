package com.acc.repository;

import com.acc.entity.CustomerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerImageRepository extends JpaRepository<CustomerImage, Long> {

    @Query(value = "SELECT COUNT(*) FROM CS_HO_CUST_IMAGEMAST WHERE COD_CUST_ID = ?1 AND flg_mnt_status ='A'", nativeQuery = true)
    int countByCustomerId(Long customerId);
}
