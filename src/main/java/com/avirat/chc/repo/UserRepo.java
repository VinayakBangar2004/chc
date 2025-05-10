package com.avirat.chc.repo;

import com.avirat.chc.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    public Optional<UserEntity> findByUserName(String userName);

    @Query(value = "SELECT * FROM cenntralizedhealthcardapplication.user_info WHERE user_id=? and health_id=?;",nativeQuery = true)
    public Optional<UserEntity> getUserDataForCheck(String userName,Long healthCardNo);

    public Optional<UserEntity> findBydoctorRegNo(Long doctorRegNo);

    public Optional<UserEntity> findByhealthCardNo(Long healthCardNo);




}
