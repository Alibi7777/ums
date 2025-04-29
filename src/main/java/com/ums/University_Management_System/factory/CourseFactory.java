package com.ums.University_Management_System.factory;


import com.ums.University_Management_System.dto.CourseDTO;
import com.ums.University_Management_System.entity.Course;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CourseFactory {

    public Course createFromDTO(CourseDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setStudentCount(0);
        course.setCreatedAt(LocalDate.now());
        return course;
    }
}

