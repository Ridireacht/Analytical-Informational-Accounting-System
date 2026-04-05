package com.vasiliy.project.dto.info;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiseaseTypeDTO {

    private Long id;

    private Double currentYearMultiplier;

    private List<Double> monthMultipliers;

    private Double nextWeekMultiplier;

    private Double nextMonthMultiplier;

    private List<Integer> years_accounted;

    private List<Double> diseaseCountsPerYear;

    private String diseaseName;
}
