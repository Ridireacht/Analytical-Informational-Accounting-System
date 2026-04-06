package com.vasiliy.project.dto.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    private String code;

    private String name;
}
