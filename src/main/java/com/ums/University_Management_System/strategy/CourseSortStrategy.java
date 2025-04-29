package com.ums.University_Management_System.strategy;

import com.ums.University_Management_System.entity.Course;

import java.util.List;

public interface CourseSortStrategy {
    List<Course> sort(List<Course> courses);
}
