package com.acc.repository;

import com.acc.entity.ChAcctMast;
import com.acc.model.dto.Customer.CustomerAccountInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChAcctMastRepo extends JpaRepository<ChAcctMast, Long> {
    @Query("SELECT COUNT(c) FROM ChAcctMast c WHERE c.flgMntStatus='A' and TRIM(c.codAcctNo) = :codAcctNo")
    long countByAcctNo(String codAcctNo);

    @Query(value = """
        SELECT  
            C.cod_acct_no AS accountNo,
            C.cod_ccy AS accountCCY,
            A.cod_cust_id AS customerId,
            A.nam_cust_full AS customerName,
            A.nam_cust_shrt AS customerShortName,
            A.cod_cust_natl_id AS customerIC,
            A.flg_cust_typ AS type,
            B.txt_cust_typ AS category,
            A.cod_cc_homebrn AS homeBranch,
            A.cod_cust_status || ':' || DECODE(NVL(A.cod_cust_status, 8), 7, 'Dormant','Regular') AS status,
            B.flg_typ_class AS classType,
            A.txt_custadr_add1 AS address1,
            A.txt_custadr_add2 AS address2,
            A.txt_custadr_add3 AS address3,
            A.nam_custadr_city AS city,
            A.nam_custadr_state AS state,
            A.nam_custadr_cntry AS country,
            A.txt_custadr_zip AS zipCode
        FROM ci_custmast A, ci_cust_types B, ch_acct_mast C 
        WHERE 
           trim(C.cod_acct_no) = :acctNo
            AND A.cod_cust_id = C.cod_cust
            AND A.flg_cust_typ = B.flg_cust_typ
            AND A.flg_mnt_status = 'A'  
            AND B.flg_mnt_status = 'A' 
            AND C.flg_mnt_status = 'A'
        """, nativeQuery = true)
    List<CustomerAccountInfoDTO> findAccountInfoByAccountNo(@Param("acctNo") String acctNo);
}