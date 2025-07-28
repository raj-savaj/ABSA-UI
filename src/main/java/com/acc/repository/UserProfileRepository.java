package com.acc.repository;

import com.acc.entity.UserProfile;
import com.acc.model.dto.userProfile.UserProfileDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {


    @Query(
            value = "SELECT cod_user_id, nam_user, cod_userno, cod_cc_brn, dat_last_sign_on, txt_email_id, dat_process, dat_last_process " +
                    "FROM sm_user_profile a, ba_bank_mast b " +
                    "WHERE cod_user_id = :userId AND a.flg_mnt_status = 'A' AND b.flg_mnt_status = 'A'",
            nativeQuery = true)
    List<UserProfileDetailsDTO> findUserDetailsByUserId(@Param("userId") String userId);
}
