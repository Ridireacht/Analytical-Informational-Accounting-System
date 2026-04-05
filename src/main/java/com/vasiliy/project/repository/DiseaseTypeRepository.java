package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseTypeRepository extends JpaRepository<DiseaseType, Long> {

}
