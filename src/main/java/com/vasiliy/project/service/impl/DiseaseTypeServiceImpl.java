package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.DiseaseTypeDTO;
import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.entity.info.DiseaseType;
import com.vasiliy.project.repository.DiseaseTypeRepository;
import com.vasiliy.project.service.DiseaseTypeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiseaseTypeServiceImpl implements DiseaseTypeService {

    private final DiseaseTypeRepository diseaseTypeRepository;

    @Override
    public List<DiseaseType> getDiseaseTypes() {
        return diseaseTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void calculateEpidemicMultipliers() {
        List<DiseaseType> diseaseTypes = diseaseTypeRepository.findAll();

        for (DiseaseType diseaseType : diseaseTypes) {
            double average = diseaseType.getDiseaseCountsPerYear().stream().mapToDouble(Double::doubleValue).sum() / diseaseType.getYearsAccounted().stream().count();

            diseaseType.setEpidemicMultiplier(getNextYearPrediction(diseaseType.getDiseaseCountsPerYear()) / average);
        }

        diseaseTypeRepository.saveAll(diseaseTypes);
    }

    private Double getNextYearPrediction(List<Double> yearValues) {
        double value;

        // Параметр сглаживания (чем выше, тем больший вес имеют более новые значения, и тем меньший - существующий прогноз)
        double alpha = 0.3;

        // Вычисляем начальное значение прогноза
        double forecast = yearValues.get(0);

        // Применяем метод экспоненциального сглаживания
        for (int i = 1; i < yearValues.size(); i++) {
            value = yearValues.get(i);
            forecast = alpha * value + (1 - alpha) * forecast;
        }

        return forecast;
    }
}
