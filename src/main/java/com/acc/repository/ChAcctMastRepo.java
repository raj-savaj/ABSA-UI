package com.acc.repository;

import com.acc.entity.ChAcctMast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChAcctMastRepo extends JpaRepository<ChAcctMast, Long> {
    @Query("SELECT COUNT(c) FROM ChAcctMast c WHERE c.flgMntStatus='A' and TRIM(c.codAcctNo) = :codAcctNo")
    long countByAcctNo(String codAcctNo);
}
