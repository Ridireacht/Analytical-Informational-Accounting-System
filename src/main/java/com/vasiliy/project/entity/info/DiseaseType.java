package com.vasiliy.project.entity.info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "disease_types")
public class DiseaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "diseaseTypes")
    private List<Category> categories;

    @ElementCollection
    @CollectionTable(name = "disease_type_disease_counts",
            joinColumns = @JoinColumn(name = "disease_type_id"))
    @Column(name = "value")
    private List<Double> diseaseCountsPerYear;

    @Column(name = "epidemic_multiplier")
    private Double epidemicMultiplier;

    @ElementCollection
    @CollectionTable(name = "disease_type_years_accounted",
            joinColumns = @JoinColumn(name = "disease_type_id"))
    @Column(name = "value")
    private List<String> yearsAccounted;

    private String name;

    @ElementCollection
    @CollectionTable(name = "disease_type_month_multipliers",
            joinColumns = @JoinColumn(name = "disease_type_id"))
    @Column(name = "value")
    private List<Double> monthMultipliers;
}
