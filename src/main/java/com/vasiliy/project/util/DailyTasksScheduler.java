package com.vasiliy.project.util;

import com.vasiliy.project.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
@AllArgsConstructor
public class DailyTasksScheduler {

    private final CategoryService categoryService;


    // Каждый день в 0:00:00 по МСК
    @Scheduled(cron = "0 0 0 * * *", zone = "Europe/Moscow")
    public void updateSeasonMultipliersOnCategories() {
        categoryService.calculateSeasonMultipliers();
    }
}
