package com.vasiliy.project.service.impl;

import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.entity.info.DiseaseType;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;


  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public List<Category> getAllCategoriesWithNbsp() {
    List<Category> categories = categoryRepository.findAll();

    for (Category category : categories) {
      int occurences = countOccurrences(category.getCode(), "-");

      String nbsps = "&emsp;&emsp;";
      nbsps = nbsps.repeat(occurences);

      category.setName(nbsps + category.getName());
    }

    return categories;
  }

  @Override
  @Transactional
  public void calculateEpidemicMultipliers() {
    List<Category> categories = categoryRepository.findAll();

    for (Category category : categories) {
      if (category.getDiseaseTypes() != null) {
        List<DiseaseType> diseaseTypes = category.getDiseaseTypes();

        int counter = 0;
        double value = 0.0;
        for (DiseaseType diseaseType : diseaseTypes) {
          counter++;
          value += diseaseType.getEpidemicMultiplier();
        }

        category.setEpidemicMultiplier(value / counter);
      }
    }

    categoryRepository.saveAll(categories);
  }

  @Override
  @Transactional
  public void calculateSeasonMultipliers() {
    List<Category> categories = categoryRepository.findAll();
    LocalDate now = LocalDate.now();
    int monthNumForNextWeek = now.plusWeeks(1).getMonthValue() - 1;
    int monthNumForNextMonth = now.plusMonths(1).getMonthValue() - 1;

    for (Category category : categories) {
      if (category.getDiseaseTypes() != null) {
        List<DiseaseType> diseaseTypes = category.getDiseaseTypes();

        int counter = 0;
        double valueForNextWeek = 0.0;
        double valueForNextMonth = 0.0;
        for (DiseaseType diseaseType : diseaseTypes) {
          if (diseaseType.getMonthMultipliers() != null) {
            counter++;
            valueForNextWeek += diseaseType.getMonthMultipliers().get(monthNumForNextWeek);
            valueForNextMonth += diseaseType.getMonthMultipliers().get(monthNumForNextMonth);
          }
        }

        if (counter != 0) {
          category.setNextWeekSeasonMultiplier(valueForNextWeek / counter);
          category.setNextWeekSeasonMultiplier(valueForNextMonth / counter);
        }
      }
    }

    categoryRepository.saveAll(categories);
  }


  public static int countOccurrences(String text, String pattern) {
    return text.split(pattern, -1).length - 1;
  }
}
