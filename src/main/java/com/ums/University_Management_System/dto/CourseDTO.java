package com.ums.University_Management_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private int studentCount;
}
