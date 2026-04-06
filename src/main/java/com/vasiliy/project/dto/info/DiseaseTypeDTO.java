package com.vasiliy.project.dto.info;

import com.vasiliy.project.entity.info.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiseaseTypeDTO {

    private Long id;

    private List<CategoryDTO> categories;

    private List<Double> diseaseCountsPerYear;

    private Double epidemicMultiplier;

    private List<String> yearsAccounted;

    private String name;

    private List<Double> monthMultipliers;
}
