package com.ums.University_Management_System.strategy;


import com.ums.University_Management_System.entity.Course;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("sortByStudents")
public class SortByStudentsStrategy implements CourseSortStrategy {
    @Override
    public List<Course> sort(List<Course> courses) {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getStudentCount).reversed())
                .collect(Collectors.toList());
    }
}

