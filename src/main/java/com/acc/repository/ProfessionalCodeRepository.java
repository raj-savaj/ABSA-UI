package com.acc.repository;

import com.acc.entity.CiProfCode;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfessionalCodeRepository extends JpaRepository<CiProfCode, String> {

    @Query("SELECT c FROM CiProfCode c WHERE c.txtProfessCat = :cat AND c.flgMntStatus = 'A'")
    Optional<CiProfCode> findActiveByTxtProfessCat(@Param("cat") Long cat);

    boolean existsByTxtProfessCatAndFlgMntStatus(String cat, String status);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CI_PROF_CODES " +
            "SET TXT_PROFESSION = :profession, CTR_UPDAT_SRLNO = :srlno + 1 " +
            "WHERE TXT_PROFESS_CAT = :cat AND FLG_MNT_STATUS = 'A' AND CTR_UPDAT_SRLNO = :srlno",
            nativeQuery = true)
    int updateProfession(@Param("cat") String cat,@Param("profession") String profession,
                               @Param("srlno") int srlno);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM CI_PROF_CODES WHERE TXT_PROFESS_CAT = :cat AND CTR_UPDAT_SRLNO = :srlno",
            nativeQuery = true)
    int deleteByCatAndSrl(@Param("cat") String cat, @Param("srlno") int srlno);

}
