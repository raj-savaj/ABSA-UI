package com.acc.repository;

import com.acc.entity.CustomerEntity;
import com.acc.model.dto.Customer.CustomerSearchResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerSearchRepository extends JpaRepository<CustomerEntity, String> {

    @Query(value = """
    SELECT 
        A.cod_cust_id AS customerId,
        A.nam_cust_full AS customerName,
        A.nam_cust_shrt AS customerShortName,
        A.cod_cust_natl_id AS customerIC,
        A.flg_cust_typ AS type,
        B.txt_cust_typ AS category,
        A.cod_cc_homebrn AS homeBranch,
        B.flg_typ_class AS typeClass,
        NVL(A.txt_custadr_add1, '') || ' ' || NVL(A.txt_custadr_add2, '') || ' ' || NVL(A.txt_custadr_add3, '') AS fullAddress
    FROM 
        ci_custmast A,
        ci_cust_types B
    WHERE 
        LOWER(A.nam_cust_shrt) LIKE LOWER('%' || :shortName || '%')
        AND A.flg_cust_typ = B.flg_cust_typ
        AND B.flg_mnt_status = 'A'
    """, nativeQuery = true)
    List<Object[]> searchByCustomerShortName(@Param("shortName") String shortName);

    @Query(value = """
    SELECT 
        A.cod_cust_id AS customerId, 
        A.nam_cust_full AS customerName, 
        A.nam_cust_shrt AS customerShortName,
        A.cod_cust_natl_id AS customerIC, 
        A.flg_cust_typ AS type, 
        B.txt_cust_typ AS category,
        A.cod_cc_homebrn AS homeBranch, 
        B.flg_typ_class AS typeClass,
        TRIM(
            COALESCE(A.txt_custadr_add1, '') || ' ' ||
            COALESCE(A.txt_custadr_add2, '') || ' ' ||
            COALESCE(A.txt_custadr_add3, '')
        ) AS fullAddress
    FROM 
        ci_custmast A, 
        ci_cust_types B
    WHERE 
        A.cod_cust_id = :customerId
        AND A.flg_cust_typ = B.flg_cust_typ
        AND B.flg_mnt_status = 'A'
    """, nativeQuery = true)
    List<Object[]> searchCustomerById(@Param("customerId") Long customerId);


    @Query(value = """
    SELECT 
        A.cod_cust_id AS "Customer Id",
        A.nam_cust_full AS "Customer Name",
        A.nam_cust_shrt AS "Customer Short Name",
        A.cod_cust_natl_id AS "Customer IC",
        A.flg_cust_typ AS "Type",
        B.txt_cust_typ AS "Category",
        A.cod_cc_homebrn AS "Home Branch",
        A.cod_cust_status || ':' || DECODE(NVL(A.cod_cust_status, 8), 7, 'Dormant', 'Regular') AS "Status",
        B.flg_typ_class,
        A.txt_custadr_add1,
        A.txt_custadr_add2,
        A.txt_custadr_add3
    FROM 
        ci_custmast A,
        ci_cust_types B
    WHERE 
        A.cod_cust_natl_id = :searchString
        AND A.flg_cust_typ = B.flg_cust_typ
        AND B.flg_mnt_status = 'A'
    """, nativeQuery = true)
    List<Object[]> searchCustomerByCustomerIc(@Param("searchString") String searchString);

}
