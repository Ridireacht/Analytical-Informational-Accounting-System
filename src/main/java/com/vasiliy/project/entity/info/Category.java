package com.vasiliy.project.entity.info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {

  public Category() {
  }

  public Category(String code, String name) {
    this.code = code;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  private String name;


  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> products;

  @Column(name = "epidemic_multiplier")
  private Double epidemicMultiplier;

  @Column(name = "next_month_season_multiplier")
  private Double nextMonthSeasonMultiplier;

  @Column(name = "next_week_season_multiplier")
  private Double nextWeekSeasonMultiplier;

  @ManyToMany
  @JoinTable(
          name = "category_disease_type",
          joinColumns = @JoinColumn(name = "category_id"),
          inverseJoinColumns = @JoinColumn(name = "disease_type_id")
  )
  private List<DiseaseType> diseaseTypes;
}
