package com.avirat.chc.repo;

import com.avirat.chc.entity.PatientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInfoRepo extends JpaRepository<PatientInfoEntity, Integer> {
}
