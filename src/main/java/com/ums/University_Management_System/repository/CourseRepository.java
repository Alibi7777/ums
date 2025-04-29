package com.ums.University_Management_System.repository;

import com.ums.University_Management_System.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
