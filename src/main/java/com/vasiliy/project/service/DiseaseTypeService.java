package com.vasiliy.project.service;

import com.vasiliy.project.entity.info.DiseaseType;

import java.util.List;

public interface DiseaseTypeService {
    List<DiseaseType> getDiseaseTypes();

    void calculateEpidemicMultipliers();
}
