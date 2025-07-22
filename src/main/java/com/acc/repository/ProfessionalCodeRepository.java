package com.acc.repository;

import com.acc.entity.CiProfCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfessionalCodeRepository extends JpaRepository<CiProfCode, String> {

    @Query("SELECT c FROM CiProfCode c WHERE c.txtProfessCat = :cat AND c.flgMntStatus = 'A'")
    Optional<CiProfCode> findActiveByTxtProfessCat(@Param("cat") Long cat);

    boolean existsByTxtProfessCatAndFlgMntStatus(String cat, String status);

    @Modifying
    @Query("UPDATE CiProfCode c SET c.txtProfession = :profession, c.ctrUpdatSrlno = c.ctrUpdatSrlno + 1 " +
            "WHERE c.txtProfessCat = :cat AND c.flgMntStatus = 'A' AND c.ctrUpdatSrlno = :srlno")
    int updateProfession(@Param("profession") String profession,
                         @Param("cat") String cat,
                         @Param("srlno") int srlno);

    @Modifying
    @Query("DELETE FROM CiProfCode c WHERE c.txtProfessCat = :cat AND c.flgMntStatus = 'A' AND c.ctrUpdatSrlno = :srlno")
    int deleteByCatAndSrl(@Param("cat") String cat, @Param("srlno") int srlno);

}
