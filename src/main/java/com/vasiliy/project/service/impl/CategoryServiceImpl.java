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
      if (!category.getDiseaseTypes().isEmpty()) {
        List<DiseaseType> diseaseTypes = category.getDiseaseTypes();

        int counter = 0;
        double value = 0.0;
        for (DiseaseType diseaseType : diseaseTypes) {
          counter++;
          value += diseaseType.getEpidemicMultiplier();
        }

        double result = value / counter;
        double roundedResult = Math.round(result * 100.0) / 100.0;

        category.setEpidemicMultiplier(roundedResult);
      }
    }

    categoryRepository.saveAll(categories);
  }

  @Override
  @Transactional
  public void calculateSeasonMultipliers() {
    List<Category> categories = categoryRepository.findAll();
    LocalDate now = LocalDate.now();

    int monthNumForNow = now.getMonthValue() - 1;
    int monthNumForNextWeek = now.plusWeeks(1).getMonthValue() - 1;
    int monthNumForNextMonth = now.plusMonths(1).getMonthValue() - 1;

    for (Category category : categories) {
      if (category.getDiseaseTypes() != null) {
        List<DiseaseType> diseaseTypes = category.getDiseaseTypes();

        int counter = 0;
        double valueForNow = 0.0;
        double valueForNextWeek = 0.0;
        double valueForNextMonth = 0.0;

        for (DiseaseType diseaseType : diseaseTypes) {
          if (diseaseType.getMonthMultipliers() != null && !diseaseType.getMonthMultipliers().isEmpty()) {
            counter++;
            valueForNow += diseaseType.getMonthMultipliers().get(monthNumForNow);
            valueForNextWeek += diseaseType.getMonthMultipliers().get(monthNumForNextWeek);
            valueForNextMonth += diseaseType.getMonthMultipliers().get(monthNumForNextMonth);
          }
        }

        if (counter != 0) {
          double currentSeasonMultiplier = valueForNow / counter;
          double nextWeekSeasonMultiplier = valueForNextWeek / counter;
          double nextMonthSeasonMultiplier = valueForNextMonth / counter;

          category.setCurrentSeasonMultiplier(Math.round(currentSeasonMultiplier * 100.0) / 100.0);
          category.setNextWeekSeasonMultiplier(Math.round(nextWeekSeasonMultiplier * 100.0) / 100.0);
          category.setNextMonthSeasonMultiplier(Math.round(nextMonthSeasonMultiplier * 100.0) / 100.0);
        }
      }
    }

    categoryRepository.saveAll(categories);
  }


  public static int countOccurrences(String text, String pattern) {
    return text.split(pattern, -1).length - 1;
  }
}
