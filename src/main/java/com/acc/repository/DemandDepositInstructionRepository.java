package com.acc.repository;

import com.acc.entity.ChAcctMast;
import com.acc.model.dto.si.SearchInstructionDetailsResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandDepositInstructionRepository extends JpaRepository<ChAcctMast, String> {

    @Query(value = "SELECT a.cod_acct_no AS accountNumber, a.cod_acct_title AS customerName, a.cod_cc_brn AS branchCode, a.cod_prod AS productCode, b.nam_product AS productName FROM ch_acct_mast a, ch_prod_mast b WHERE a.cod_acct_no = :accountNumber AND a.cod_prod = b.cod_prod AND a.flg_mnt_status = 'A' AND b.flg_mnt_status = 'A'", nativeQuery = true)
    List<SearchInstructionDetailsResponseDTO> findAddModeData(@Param("accountNumber") String accountNumber);

    @Query(value = "SELECT DISTINCT a.cod_acct_no AS accountNumber, a.cod_acct_title AS customerName, a.cod_cc_brn AS branchCode, a.cod_prod AS productCode, b.nam_product AS productName, c.ctr_si_inst_no AS instructionNo FROM ch_acct_mast a, ch_prod_mast b, ch_si_table c WHERE a.cod_acct_no = :accountNumber AND c.cod_acct_no = a.cod_acct_no AND a.cod_prod = b.cod_prod AND a.flg_mnt_status = 'A' AND b.flg_mnt_status = 'A' AND c.flg_mnt_status = 'A'", nativeQuery = true)
    List<SearchInstructionDetailsResponseDTO> findInstructionData(@Param("accountNumber") String accountNumber);
}

