package com.acc.repository;

import com.acc.entity.CiCustMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiCustMemoRepository extends JpaRepository<CiCustMemo, Long> {
    @Query("SELECT c FROM CiCustMemo c WHERE c.codCustId = :custId AND c.flgMntStatus = 'A'")
    List<CiCustMemo> findActiveMemosByCustId(Long custId);

    @Modifying
    @Query("UPDATE CiCustMemo c SET c.txtCustMemo = :memo, c.flgSeverity = :severity, c.codReason = :reason " +
            "WHERE c.codCustId = :custId AND c.ctrUpdatSrlNo = :srlNo AND c.flgMntStatus = 'A'")
    int updateMemo(Long custId, String memo, String severity, Integer reason, Long srlNo);

    @Modifying
    @Query("DELETE FROM CiCustMemo c WHERE c.codCustId = :custId AND c.ctrUpdatSrlNo = :srlNo AND c.flgMntStatus = 'A'")
    int deleteMemo(Long custId, Long srlNo);
}