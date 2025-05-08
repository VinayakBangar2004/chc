package com.avirat.chc.repo;

import com.avirat.chc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    public Optional<UserEntity> findByUserName(String userName);
}
