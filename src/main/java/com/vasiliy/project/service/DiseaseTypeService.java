package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.DiseaseTypeDTO;
import com.vasiliy.project.entity.info.DiseaseType;

import java.util.List;

public interface DiseaseTypeService {
    List<DiseaseTypeDTO> getDiseaseTypes();

    void calculateEpidemicMultipliers();
}
